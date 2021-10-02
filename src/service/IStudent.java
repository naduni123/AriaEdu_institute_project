package service;

import model.Student;

import java.util.ArrayList;

public interface IStudent {

    public void addStudent(Student student);//Add Student
    public void editStudent(Student student);//Update Student
    public ArrayList<Student> ViewStudent();//View Students List
    public Student selectStudent(int id);//Select Student
    public boolean deleteStudent(int id, String firstName, String lastName);//Delete Student
}