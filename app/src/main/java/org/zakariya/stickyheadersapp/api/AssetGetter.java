package org.zakariya.stickyheadersapp.api;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;
import org.zakariya.stickyheadersapp.model.Lesson;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by hcummings on 6/23/2016.
 */

public class AssetGetter {

    public static String[] getSectionNames(Context ctx, String sectionName){

        try {
            return ctx.getAssets().list(sectionName);
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
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

        //todo run this async please... thanks!
        LinkedHashMap<String, ArrayList<Lesson>> sectionInfo = new LinkedHashMap<>();

        String[] sections = AssetGetter.getSectionNames(ctx, topLevelFolder);

        for (String sectionKey : sections) {

            sectionInfo.put(sectionKey, new ArrayList<Lesson>());

            String fullSectionKeyUrl = topLevelFolder + File.separator + sectionKey;
            String[] subSections = AssetGetter.getSectionNames(ctx, fullSectionKeyUrl);

            int x = 0;
            while (x < subSections.length) {
                String subsectName = subSections[x];
                String fullName = fullSectionKeyUrl + File.separator + subsectName;
                String[] jsonFiles = AssetGetter.getSectionNames(ctx, fullName);

                for (String jsonFile : jsonFiles) {
                    String fileName = fullName + File.separator + jsonFile;
                    if(!fileName.contains(".json"))
                        continue;

                    String json = AssetGetter.getJsonStringBySectionName(ctx, fileName);
                    Lesson lesson = AssetGetter.getLessonFromJson(json);
                    lesson.setChapter(sectionKey);
                    lesson.setTopic(subsectName);
                    ArrayList<Lesson> sect = sectionInfo.get(sectionKey);
                    sect.add(x, lesson);
                }
                x++;
            }
        }

        return sectionInfo;
    }


}
