package service;

import model.Attendance;
import model.AttendanceMarker;
import model.Student;
import util.DBConnectionUtil;
import util.QueryAttendance;
import util.QueryTimeAndClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            preparedStatement.setInt(2,attendance.getStatus());



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

    public ArrayList<Student> viewbySubject(String subject, String batch){

        ArrayList<Student> list = new ArrayList<>();

        try {

            con = DBConnectionUtil.getConnection();
            String sql = "select * from studentdetails where id in(select sid from studentlearnsubject where subject='"+subject+"' and batch='"+batch+"')";


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

}
