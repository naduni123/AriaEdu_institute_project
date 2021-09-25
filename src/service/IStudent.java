package service;

import model.Student;

import java.util.ArrayList;

public interface IStudent {

    public void addStudent(Student student);//addStudent
    public void editStudent(Student student);
    public ArrayList<Student> ViewStudent();
    public Student selectStudent(int id);
}
