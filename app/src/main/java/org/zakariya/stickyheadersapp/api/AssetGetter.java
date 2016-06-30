package org.zakariya.stickyheadersapp.api;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
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
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.zakariya.stickyheadersapp.custom.SectionsLoaded;
import org.zakariya.stickyheadersapp.model.DemoModel;
import org.zakariya.stickyheadersapp.ui.CollapsingSectionsDemoActivity;
import org.zakariya.stickyheadersapp.ui.MainActivity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static java.util.HashMap.*;

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

        Query allChapters = mDatabase.child(folder);
        allChapters.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ArrayList<Chapter> Book = new ArrayList<>();
                HashMap object = (HashMap) dataSnapshot.getValue();
                for (int i=0; i< object.size(); i++){
                    Object current = object.entrySet().toArray()[i];
                    String title = object.keySet().toArray()[i].toString();
                    String description = GetdescriptionFromSubFolderNames();

                    try {
                        HashMap<String,HashMap.Entry> subFolders;
                        subFolders = (HashMap<String, HashMap.Entry>) ((Entry) current).getValue();

                        ArrayList<Section> sections = new ArrayList<Section>();
                        for (int j=0; j < subFolders.size() ; j++) {
                            Entry  section = (Entry) subFolders.entrySet().toArray()[j];
                            //todo build out section data
                            Section sect = new Section();

                            ArrayList<Lesson> lessons = new ArrayList<Lesson>();
                            HashMap<String, Map.Entry> files = (HashMap<String, HashMap.Entry>)(section).getValue();
                           for(int k=0; k < files.size(); k++){
                               String t = (String) files.keySet().toArray()[k];
                               HashMap.Entry<String, HashMap> jsonfile = (HashMap.Entry)files.entrySet().toArray()[k];
                               HashMap mMap = jsonfile.getValue();
                               //get the solution from the json hashmap
                               String solution = (String) mMap.get("Solution");

                               // get the topic
                               String topic = (String)mMap.get("Topic");

                               //get chapter
                               String chapter = (String)mMap.get("Chapter");

                               // build out lesson data
                               Lesson lesson = new Lesson(t,t,solution, topic, chapter);

                               // add lesson to lessons
                               lessons.add(lesson);

                               //todo save lessons to section
                               if(k ==0){
                                   sect.setHeader(topic);
                                   sect.setFooter(String.format("End of :%s", topic));
                               }

                               //set lessons
                               sect.getLessons().add(lesson);
                           }

                            // save section to section list
                            sections.add(sect);
                        }

                        //save sections to chapter
                        Chapter chapter = new Chapter(sections);
                        chapter.setName(title);

                        //add new chapter to book
                        Book.add(chapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                SectionsLoaded delegate = (SectionsLoaded) context;

                //new data to the subscriber
                delegate.onsectionsLoaded(Book);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private static String GetdescriptionFromSubFolderNames() {
        return "description here";
    }

    private static Section[] BuildModelsFromMap(HashMap<String, Object> map) {
        Section[] sections = new Section[map.keySet().size()];
        try {
            Gson gson = new Gson();
            for(int i=0; i < sections.length; i++) {
                Section section = new Section();
                JsonObject json = new JsonObject();
                Chapter[] chapters = gson.fromJson(map.toString(), new TypeToken<ArrayList<Chapter>>(){}.getType());
               // section.setHeader();
               // section.setFooter();
                section.setHasHeader(true);
            }

        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return sections;
    }

    private static LinkedHashMap<String, ArrayList<Section>> BuildSections(HashMap firebaseData) {
        return null;
    }

    public interface sectionLoaded{

        void processSnapShot(DataSnapshot snapshot);
    }

    public static void GetLessons(String topLevelFolder) {

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        String baseUrl = "https://project-4399521862841014866.firebaseio.com/ctci/" + topLevelFolder;

        StringBuilder url = new StringBuilder();
        for(int i=0; i < topLevelFolder.length(); i++){
            char c = topLevelFolder.charAt(i);
            if(c == ' ')
                url.append("%20");
             else
                url.append(c);
        }//https://project-4399521862841014866.firebaseio.com/ctci/Arrays and Strings
        String fullUrl = baseUrl +  ".json";
        Query allChapters = mDatabase.child(topLevelFolder);
        allChapters.addListenerForSingleValueEvent(new ValueEventListener() {
         @Override
         public void onDataChange(DataSnapshot dataSnapshot) {
         }

         @Override
         public void onCancelled(DatabaseError databaseError) {
         }
     });
    }

    private static void ConvertSnapshotToSections(DataSnapshot dataSnapshot) {


   //     MainActivity.MainPageFragment.DemoModel[] demos = new MainActivity.MainPageFragment.DemoModel[sections.length];
//        for (int i = 0; i < sections.length; i++) {
//            String folderName = sections[i];
//            demos[i] = new MainActivity.MainPageFragment.DemoModel(folderName, "",CollapsingSectionsDemoActivity.class, folderName);
//        }
    }
}
