package service;

import model.Attendance;
import model.AttendanceMarker;
import model.Student;
import util.DBConnectionUtil;
import util.QueryAttendance;
import util.QueryTimeAndClass;

import java.sql.*;
import java.util.ArrayList;

public class AttendanceService implements IAttendance{

    Connection con;
    PreparedStatement preparedStatement;
    @Override
    public ArrayList<Student> loadStudent() {

        ArrayList<Student> list = new ArrayList<>();

        try {

            con = DBConnectionUtil.getConnection();
            String sql = QueryAttendance.SEE_STUDENT;


            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

               Student student = new Student();

               student.setId(rs.getInt(1));
               student.setFirstName(rs.getString(2)+" "+rs.getString(3));


                list.add(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addAttendance(Attendance attendance) {
        try {
            con = DBConnectionUtil.getConnection();
            String sql = QueryAttendance.ADD_ATT;
            preparedStatement = con.prepareStatement(sql);
            System.out.println(sql);


            preparedStatement.setInt(1,attendance.getId());
            preparedStatement.setDate(2,attendance.getTimestamp());
            preparedStatement.setInt(3,attendance.getStatus());
            preparedStatement.setString(4,attendance.getSubject());
            preparedStatement.setString(5,attendance.getBatch());



            System.out.println(sql);

            preparedStatement.execute();

        }catch(Exception e){

            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Attendance> seeAttendance() {
        ArrayList<Attendance> list = new ArrayList<>();

        try {

            con = DBConnectionUtil.getConnection();
            String sql = QueryAttendance.SEE_ATT;


            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Attendance attendance = new Attendance();

                attendance.setId(rs.getInt(1));
                attendance.setName(rs.getString(2)+" "+rs.getString(3));
                attendance.setStatus(rs.getInt(4));


                list.add(attendance);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
    public ArrayList<Student> viewbySubject(String subject, String batch) {

        ArrayList<Student> list = new ArrayList<>();

        try {

            con = DBConnectionUtil.getConnection();
            String sql =
                    "select * from studentlearnsubject l, studentdetails s where batch='"+batch+"' and s.id in (select sid from studentlearnsubject where subject='"+subject+"') and s.id = l.sid";

            System.out.println("hel");
            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Student student = new Student();

                student.setId(rs.getInt(1));
                student.setFirstName(rs.getString(5) + " " + rs.getString(6));
                student.setTempSubject(rs.getString(3));
                student.setBatch(rs.getString(14));

                System.out.println("getBatch"+student.getBatch());



                list.add(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;


    }



    public ArrayList<Attendance> viewAttendancebySubject(String subject, String batch, Date date){

        ArrayList<Attendance> list = new ArrayList<>();

        try {

            con = DBConnectionUtil.getConnection();
            String sql = "select * from studentdetails s , attendance a where s.id in(select sid from attendance where date='"+date+"' and subject='" + subject +"' and batch='" + batch +"') and s.id=a.sid";


            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Attendance student = new Attendance();

                student.setId(rs.getInt(1));
                student.setName(rs.getString(2)+" "+rs.getString(3));

                student.setStatus(rs.getInt(15));



                list.add(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;



    }

}
