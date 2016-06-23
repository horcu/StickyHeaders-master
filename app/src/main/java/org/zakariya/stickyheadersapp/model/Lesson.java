package org.zakariya.stickyheadersapp.model;

/**
 * Created by hcummings on 6/22/2016.
 */
public class Lesson {



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
   private String Topic;
   private String Chapter;

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
}
