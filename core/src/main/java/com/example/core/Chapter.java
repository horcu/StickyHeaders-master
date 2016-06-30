package com.example.core;

import java.util.ArrayList;

/**
 * Created by Horatio on 6/29/2016.
 */

public class Chapter {
    private String name;
    private Lesson[] lessons;
    private ArrayList<Section> sections;

    public Chapter(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public Lesson[] getLessons() {
        return lessons;
    }

    public void setLessons(Lesson[] lessons) {
        this.lessons = lessons;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
