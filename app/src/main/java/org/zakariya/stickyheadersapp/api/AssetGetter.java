package org.zakariya.stickyheadersapp.api;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.core.Chapter;
import com.example.core.Lesson;
import com.example.core.Section;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;
import org.zakariya.stickyheadersapp.custom.SectionsLoaded;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import static java.util.HashMap.Entry;

/**
 * Created by hcummings on 6/23/2016.
 */

public class AssetGetter {

    public static String[] getSectionNames(Context ctx, String sectionName){

        String [] folderList = null;
        try {
           folderList =  ctx.getAssets().list(sectionName);
            int len = folderList.length;

            for (int i=0; i < len; i ++) {
                String filename = folderList[i];
                if(filename.contains(".json"))
                   folderList[i]=null;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return folderList;
    }

    public static String[] getFileNames(Context ctx, String sectionName){

        String [] folderList = null;
        try {
            folderList =  ctx.getAssets().list(sectionName);
            int len = folderList.length;

            for (int i=0; i < len; i ++) {
                String filename = folderList[i];
                if(!filename.contains(".json"))
                    folderList[i]=null;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return folderList;
    }

    public static String getJsonStringBySectionName( Context context, String filename )
    {
        InputStream is = null;
        byte[] buffer = new byte[0];
        try {
            is = context.getAssets().open(filename);
            int size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // return "{This is a test";
       return new String(buffer);
    }

    public static Lesson getLessonFromJson(String json){
        try {
            GsonBuilder gson = new GsonBuilder();
            Lesson lesson = gson.create().fromJson(json, Lesson.class);
            return lesson;
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    @NonNull
    public static LinkedHashMap<String, ArrayList<Lesson>> GetLessonsAssets(Context ctx, String topLevelFolder) {
        LinkedHashMap<String, ArrayList<Lesson>> sectionInfo = null;
        try {
            //todo run this async please... thanks!
            sectionInfo = new LinkedHashMap<>();

            String root = "CTCI";
            String fullPath = root + File.separator + topLevelFolder;
            String[] sections = AssetGetter.getSectionNames(ctx, fullPath);

            for (String sectionKey : sections) {
                sectionKey = sectionKey.replace("_", " ");
                sectionInfo.put(sectionKey, new ArrayList<Lesson>());

                String fullSectionKeyUrl = fullPath + File.separator + sectionKey;
                String[] chapterSections = AssetGetter.getSectionNames(ctx, fullSectionKeyUrl);

                extractLesson(ctx, sectionInfo, sectionKey, fullSectionKeyUrl, chapterSections);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sectionInfo;
    }

    private static void extractLesson(Context ctx, LinkedHashMap<String, ArrayList<Lesson>> sectionInfo, String sectionKey, String fullSectionKeyUrl, String[] chapterSections) {

        for (int x=0; x < chapterSections.length; x ++) {
            String lessonFileName = chapterSections[x];

            if(!lessonFileName.endsWith(".json")) {
                // its a deeper nested folder structure
                fullSectionKeyUrl = fullSectionKeyUrl + File.separator + lessonFileName;
                String[] fileNames = AssetGetter.getFileNames(ctx, fullSectionKeyUrl);
                extractLesson(ctx,sectionInfo,lessonFileName,fullSectionKeyUrl, fileNames);
            }

            String fullName = fullSectionKeyUrl + File.separator + lessonFileName;
            String json = AssetGetter.getJsonStringBySectionName(ctx, fullName);

            Lesson lesson = AssetGetter.getLessonFromJson(json);
            if(lesson == null) {
                Toast.makeText(ctx, "couldn't display the code for " + lessonFileName, Toast.LENGTH_LONG).show();
                continue;
            }
            String parsedName = lessonFileName.replace(".json","");

            lesson.setTopic(parsedName);
            lesson.setChapter(lessonFileName);
            ArrayList<Lesson> sect = sectionInfo.get(sectionKey);
            sect.add(x, lesson);
        }
    }

    public static void ListChapters(final Activity context, String folder) {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        Query allChapters = mDatabase.child("/directory/Cracking the Code/" + folder);
        allChapters.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ArrayList<Section> Book = null;
                Object object = null;
                try {
                    object =  dataSnapshot.getValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Gson gson = new Gson();
                String json = gson.toJson(object);
                Book = BuildSectionAndLessonsFromJson(json);

                //new data to the subscriber
                SectionsLoaded delegate = (SectionsLoaded) context;
                delegate.onsectionsLoaded(Book);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public static ArrayList<Section> BuildSectionAndLessonsFromJson(String json) {

        Gson gson = new Gson();
        ArrayList<Section> results = new ArrayList<>();
        JsonObject jObj = gson.fromJson(json,JsonObject.class);

        JsonObject jArrayStr = jObj.getAsJsonObject("directory");

        try {
            for (int i=0; i < jArrayStr.entrySet().size(); i++){

                //the sections
                Set<Entry<String, JsonElement>> currentObj = jArrayStr.entrySet();

                for (int j=0; j < currentObj.size(); j++) {
                    Entry<String, JsonObject> obj = (Entry) currentObj.toArray()[j];
                    Section sec = new Section();
                    sec.setHasFooter(true);
                    sec.setHasHeader(true);

                    String chapter = "";

                    ArrayList<Lesson> lessons = new ArrayList<>();

                    chapter = obj.getKey();
                    JsonObject lesson = obj.getValue();
                    Set<Entry<String, JsonElement>> lessonfile = lesson.entrySet();
                    Entry<String, JsonArray> tfileMap = (Entry<String, JsonArray>) lessonfile.toArray()[0];

                    String title = tfileMap.getKey();
                    JsonArray solutions = tfileMap.getValue();

                    for (int k = 0; k < solutions.size(); k++) {
                        JsonElement solEntries = solutions.get(k);
                        Lesson less = new Lesson(title, "", solEntries.getAsString(), title, chapter);
                        lessons.add(less);
                    }

                    if (j == 0) {
                        sec.setHeader(chapter);
                        sec.setFooter(String.format("End of: %s", chapter));
                    }

                    sec.setNumberOfItems(lessons.size());
                    sec.setLessons(lessons);
                    sec.setAdapterPosition(i);
                    // sec.setIndex(i);
                    results.add(sec);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    private static String GetdescriptionFromSubFolderNames() {
        return "description here";
    }


    public interface sectionLoaded{

        void processSnapShot(DataSnapshot snapshot);
    }
}
