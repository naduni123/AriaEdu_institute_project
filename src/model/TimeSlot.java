package model;

import java.sql.Time;

//model for timesslot
public class TimeSlot {
    
    private int id;
    private int batch;
    private String date;
    private String startTime;
    private String endTime;
    private String subject;
    private int classroom;
    private int teacher;


    public TimeSlot(int id, String startTime, String endTime, String subject, int classroom, int teacher) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.subject = subject;
        this.classroom = classroom;
        this.teacher = teacher;
    }

    //getters and setters

    public TimeSlot(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public int getTeacher() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
