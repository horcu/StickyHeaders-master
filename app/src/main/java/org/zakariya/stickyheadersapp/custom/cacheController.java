package org.zakariya.stickyheadersapp.custom;

import com.example.core.Lesson;
import com.google.gson.reflect.TypeToken;
import com.lifeofcoding.cacheutlislibrary.CacheUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;


/**
 * Created by Horatio on 6/24/2016.
 */

public class cacheController {

    public static void WriteToCache(String topLevelFolder, LinkedHashMap<String, ArrayList<Lesson>> sections) {
        CacheUtils.writeObjectFile(topLevelFolder, sections);
    }

    public static LinkedHashMap<String, ArrayList<Lesson>> GetFromCache(String folder) {
        return CacheUtils.readObjectFile(folder, new TypeToken<LinkedHashMap<String, ArrayList<Lesson>>>(){}.getType());
    }
}
