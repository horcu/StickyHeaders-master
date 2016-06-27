package com.example.core;

import java.util.ArrayList;

public class Section implements android.os.Parcelable {
	private int adapterPosition;    // adapterPosition of first item (the header) of this sections
	private int numberOfItems;      // number of items (not including header or footer)
	private int length;             // total number of items in sections including header and footer
	private boolean hasHeader;      // if true, sections has a header
	private boolean hasFooter;      // if true, sections has a footer
	private int index;
	private int copyCount;
	private String header;
	private String footer;
	private ArrayList<Section> sections = new ArrayList<>();
	private ArrayList<Lesson> lessons = new ArrayList<>();

    public Section(){}

    public Section(int adapterPosition, int numberOfItems, int length, boolean hasHeader, boolean hasFooter, int index, int copyCount, String header, String footer){
        this.adapterPosition = adapterPosition;
        this.numberOfItems = numberOfItems;
        this.length = length;
        this.hasHeader = hasHeader;
        this.hasFooter = hasFooter;
        this.index = index;
        this.copyCount = copyCount;
        this.header = header;
        this.footer = footer;
    }

    public int getAdapterPosition() {
        return adapterPosition;
    }

    public void setAdapterPosition(int adapterPosition) {
        this.adapterPosition = adapterPosition;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isHasHeader() {
        return hasHeader;
    }

    public void setHasHeader(boolean hasHeader) {
        this.hasHeader = hasHeader;
    }

    public boolean isHasFooter() {
        return hasFooter;
    }

    public void setHasFooter(boolean hasFooter) {
        this.hasFooter = hasFooter;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCopyCount() {
        return copyCount;
    }

    public void setCopyCount(int copyCount) {
        this.copyCount = copyCount;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeInt(this.adapterPosition);
        dest.writeInt(this.numberOfItems);
        dest.writeInt(this.length);
        dest.writeByte(this.hasHeader ? (byte) 1 : (byte) 0);
        dest.writeByte(this.hasFooter ? (byte) 1 : (byte) 0);
        dest.writeInt(this.index);
        dest.writeInt(this.copyCount);
        dest.writeString(this.header);
        dest.writeString(this.footer);
        dest.writeList(this.sections);
        dest.writeList(this.lessons);
    }

    protected Section(android.os.Parcel in) {
        this.adapterPosition = in.readInt();
        this.numberOfItems = in.readInt();
        this.length = in.readInt();
        this.hasHeader = in.readByte() != 0;
        this.hasFooter = in.readByte() != 0;
        this.index = in.readInt();
        this.copyCount = in.readInt();
        this.header = in.readString();
        this.footer = in.readString();
        this.sections = new ArrayList<Section>();
        in.readList(this.sections, Section.class.getClassLoader());
        this.lessons = new ArrayList<Lesson>();
        in.readList(this.lessons, Lesson.class.getClassLoader());
    }

    public static final android.os.Parcelable.Creator<Section> CREATOR = new android.os.Parcelable.Creator<Section>() {
        @Override
        public Section createFromParcel(android.os.Parcel source) {
            return new Section(source);
        }

        @Override
        public Section[] newArray(int size) {
            return new Section[size];
        }
    };
}