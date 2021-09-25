package model;

import java.sql.Date;

public class AttendanceMarker extends Person{

    //should be fixed
    private int id;
    private String teacher;
    private String[] subject;
    private String list;

    public AttendanceMarker(String fname, String lname, String email, String password, Date dob, String gender, String teacher, String[] subject) {
        super(fname, lname, email, password, dob, gender);
        this.teacher = teacher;
        this.subject = subject;
    }

    public AttendanceMarker(){}

    public String getTeacher() {
        return teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String[] getSubject() {
        return subject;
    }

    public void setSubject(String[] subject) {
        this.subject = subject;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }
}
