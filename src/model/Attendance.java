package model;

import java.sql.Timestamp;

public class Attendance {

    private int id;
    private int studentId;
    private String name;
    private String subject;
    private String batch;
    private Timestamp timestamp;
    private int status;


    public Attendance(int id, int studentId, String subject, Timestamp timestamp, int status) {
        this.id = id;
        this.studentId = studentId;
        this.subject = subject;
        this.timestamp = timestamp;
        this.status = status;
    }

    public Attendance(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
