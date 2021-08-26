package service;

import model.Student;
import util.DBConnectionUtil;
import util.QueryStudent;

import java.sql.*;
import java.util.ArrayList;

public class StudentService implements IStudent{
    //declare variables
    Connection con;
    PreparedStatement preparedStatement;

    //Add Student
    @Override
    public void addStudent(Student student) {
        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //SQL QUERY (INSERT)
            String sql = QueryStudent.ADD_STUDENT;
            //Create a statement using connection object
            preparedStatement = con.prepareStatement(sql);
            System.out.println(sql);

            //Get data from form inputs and Add data to PreparedStatement
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getGender());
            preparedStatement.setDate(4, student.getDob());
            preparedStatement.setString(5, student.getNic());
            preparedStatement.setString(6, student.getAddress());
            preparedStatement.setInt(7, student.getPhone());
            preparedStatement.setString(8, student.getEmail());
            preparedStatement.setDate(9, student.getAdmissionDate());
            preparedStatement.setString(10, student.getBatch());

            System.out.println(sql);

            //Update Query (It will return the number of affected rows
            preparedStatement.execute();

            String[] temp = student.getSubject();

            for (String i : temp) {

                String sql2 = QueryStudent.ADD_STUDENT_SUBJECT;
                preparedStatement = con.prepareStatement(sql2);

                preparedStatement.setString(1, student.getFirstName());
                preparedStatement.setString(2, student.getLastName());
                preparedStatement.setString(3, i);

                preparedStatement.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        //Update Student Details
    @Override
    public void editStudent(Student student) {

    }

    //Select All Students
    @Override
    public ArrayList<Student> ViewStudent() {
        //using try-with-resources to avoid closing resources (boiler plate code)
        ArrayList<Student> list = new ArrayList<>();
        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //SQL QUERY (RETRIEVE)
            String sql = QueryStudent.SEE_ALL_STUDENT;
            //Create a statement using connection object
            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);
            //Execute the query
            ResultSet rs = preparedStatement.executeQuery();
            //Process the ResultSet object
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                String name = (rs.getString(2) + " " + rs.getString(3));
                String batch = rs.getString(11);


                String sql2 = QueryStudent.SEE_STUDENT_SUBJECTS;
                preparedStatement = con.prepareStatement(sql2);
                preparedStatement.setString(1,rs.getString(2));
                preparedStatement.setString(2,rs.getString(3));

                ResultSet rs2 = preparedStatement.executeQuery();

                String tempsubject="";
                while(rs2.next()){
                    System.out.println("abcd");
                    tempsubject = tempsubject+ rs2.getString(3)+" ";
                }
                System.out.println(tempsubject);
                //Create an Object
                Student student = new Student();
                System.out.println(tempsubject);

                //Retrieve Employee Details from studentdetails table(DB)
                student.setId(id);
                student.setFirstName(name);
                student.setBatch(batch);
                student.setList(tempsubject);
            System.out.println(student.getList());
                list.add(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //Select student by id
    @Override
    public Student selectStudent(int id) {

        Student student = null;
        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //SQL QUERY (RETRIEVE)
            String sql = QueryStudent.SEE_STUDENT_BY_STUDENTID;
            //Create a statement using connection object
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            //Execute the query
            ResultSet rs = preparedStatement.executeQuery();

            //Process the ResultSet object
            while (rs.next()) {
                String name = (rs.getString(2) + " " + rs.getString(3));
                String gender = rs.getString(4);
                Date dob = Date.valueOf(rs.getString(5));
                String nic = rs.getString(6);
                String address = rs.getString(7);
                int phone = Integer.parseInt(rs.getString(8));
                String email = rs.getString(9);
                Date admissionDate = Date.valueOf(rs.getString(10));
                String batch = rs.getString(11);

                String sql2 = QueryStudent.SEE_STUDENT_SUBJECTS;
                preparedStatement = con.prepareStatement(sql2);
                preparedStatement.setString(1,rs.getString(2));
                preparedStatement.setString(2,rs.getString(3));

                ResultSet rs2 = preparedStatement.executeQuery();

                String tempsubject="";
                while(rs2.next()){
                    System.out.println("abcd");
                    tempsubject = tempsubject+ rs2.getString(3)+" ";
                }
                System.out.println(tempsubject);
                //Create an Object
                student = new Student();
                System.out.println(tempsubject);

                student.setId(id);
                student.setFirstName(name);
                student.setGender(gender);
                student.setDob(dob);
                student.setNic(nic);
                student.setAddress(address);
                student.setPhone(phone);
                student.setEmail(email);
                student.setAdmissionDate(admissionDate);
                student.setBatch(batch);
                student.setList(tempsubject);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
