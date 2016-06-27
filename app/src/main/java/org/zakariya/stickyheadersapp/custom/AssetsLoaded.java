package org.zakariya.stickyheadersapp.custom;


import com.example.core.Lesson;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by Horatio on 6/23/2016.
 */

public interface AssetsLoaded {
    public void onAssetsLoadingCompleted(LinkedHashMap<String, ArrayList<Lesson>> sections);
}
