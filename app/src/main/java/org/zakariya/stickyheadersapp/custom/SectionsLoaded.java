package org.zakariya.stickyheadersapp.custom;


import com.example.core.Chapter;
import com.example.core.Lesson;
import com.example.core.Section;

import org.zakariya.stickyheadersapp.model.DemoModel;
import org.zakariya.stickyheadersapp.ui.MainActivity;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by Horatio on 6/23/2016.
 */

public interface SectionsLoaded {
    public void onsectionsLoaded(ArrayList<Chapter> sections);
}
