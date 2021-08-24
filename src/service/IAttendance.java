package service;

import model.Attendance;
import model.Student;

import java.util.ArrayList;

public interface IAttendance {

    public ArrayList<Student> loadStudent();
    public void addAttendance(Attendance attendance);
    public ArrayList<Attendance> seeAttendance();
}
