package com.ctci;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hcummings on 6/22/2016.
 */
public class Lesson implements Parcelable {



//    var obj = new QuestionObject
//    {
//        Id = Guid.NewGuid().ToString(),
//                Question = string.Empty,
//                Solution = stringFromFile,
//                Topic = GetTopic(filePath),
//                Chapter = GetChapter(filePath)
//    };

   private String Id;
   private String question;
   private String Solution;
    private String Chapter;
   private String Topic;


    public Lesson(String id, String question, String solution, String topic, String chapter){
        Id = id;
        this.question = question;
        Solution = solution;
        Topic = topic;
        Chapter = chapter;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSolution() {
        return Solution;
    }

    public void setSolution(String solution) {
        Solution = solution;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public String getChapter() {
        return Chapter;
    }

    public void setChapter(String chapter) {
        Chapter = chapter;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Id);
        dest.writeString(this.question);
        dest.writeString(this.Solution);
        dest.writeString(this.Chapter);
        dest.writeString(this.Topic);
    }

    protected Lesson(Parcel in) {
        this.Id = in.readString();
        this.question = in.readString();
        this.Solution = in.readString();
        this.Chapter = in.readString();
        this.Topic = in.readString();
    }

    public static final Parcelable.Creator<Lesson> CREATOR = new Parcelable.Creator<Lesson>() {
        @Override
        public Lesson createFromParcel(Parcel source) {
            return new Lesson(source);
        }

        @Override
        public Lesson[] newArray(int size) {
            return new Lesson[size];
        }
    };
}
