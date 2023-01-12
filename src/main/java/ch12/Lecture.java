package ch12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {

    private int passScore;
    private String title;
    private List<Integer> scores;


    public Lecture(int pass, String title, List<Integer> scores) {
        this.passScore = pass;
        this.title = title;
        this.scores = new ArrayList<>(scores);
    }

    public String getFormatString(){
        return String.format("Pass:%d Fail:%d\n", getPassStudentCount(), getFailStudentCount());
    }

    public List<Integer> getScores() {
        return Collections.unmodifiableList(scores);
    }

    private int getPassStudentCount(){
        return (int)scores.stream().filter(s->s >= passScore).count();
    }

    private int getFailStudentCount(){
        return scores.size() - getPassStudentCount();
    }
}
