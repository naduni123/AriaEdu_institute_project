package service;

import model.Classroom;
import model.TimeSlot;
import util.DBConnectionUtil;
import util.QueryTimeAndClass;

import javax.servlet.jsp.jstl.sql.Result;
import java.sql.*;
import java.util.ArrayList;

public class TimeSlotService implements ITimeSlot {

    Connection con;
    PreparedStatement preparedStatement;

    @Override
    public void AddTimeSlot(TimeSlot timeSlot) {

        try {
            con = DBConnectionUtil.getConnection();
            String sql = QueryTimeAndClass.ADD_TIMESLOT;
            preparedStatement = con.prepareStatement(sql);
            System.out.println(sql);

            preparedStatement.setInt(1,timeSlot.getBatch());
            preparedStatement.setString(2,timeSlot.getDate());
            preparedStatement.setString(3,timeSlot.getStartTime());
            preparedStatement.setString(4,timeSlot.getEndTime());
            preparedStatement.setString(5,timeSlot.getSubject());
            preparedStatement.setInt(6,timeSlot.getTeacher());
            preparedStatement.setInt(7,timeSlot.getClassroom());



            System.out.println(sql);

            preparedStatement.execute();

        }catch(Exception e){

            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<TimeSlot> viewTime() {
        ArrayList<TimeSlot> list = new ArrayList<>();

        try {

            con = DBConnectionUtil.getConnection();
            String sql=QueryTimeAndClass.SEE_TIME;

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                TimeSlot timeSlot = new TimeSlot();

                timeSlot.setSubject(rs.getString(6));
                timeSlot.setDate(rs.getString(3));
                timeSlot.setStartTime(rs.getString(4));
                timeSlot.setEndTime(rs.getString(5));
                timeSlot.setClassroom(rs.getInt(8));
                timeSlot.setBatch(rs.getInt(2));


                list.add(timeSlot);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<TimeSlot> viewTimeByTeacherID(int id) {
        ArrayList<TimeSlot> list = new ArrayList<>();
        System.out.println("in");

        try {

            con = DBConnectionUtil.getConnection();
            String sql=QueryTimeAndClass.SEE_TIME_TEACHER+id;

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                TimeSlot timeSlot = new TimeSlot();

                timeSlot.setSubject(rs.getString(6));
                timeSlot.setDate(rs.getString(3));
                timeSlot.setStartTime(rs.getString(4));
                timeSlot.setEndTime(rs.getString(5));
                timeSlot.setClassroom(rs.getInt(8));
                timeSlot.setBatch(rs.getInt(2));

                System.out.println(timeSlot.getId());
                list.add(timeSlot);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<TimeSlot> viewTimeByBatchID(int id) {
        ArrayList<TimeSlot> list = new ArrayList<>();
        System.out.println("in");

        try {

            con = DBConnectionUtil.getConnection();
            String sql=QueryTimeAndClass.SEE_TIME_BATCH+id;

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                TimeSlot timeSlot = new TimeSlot();

                timeSlot.setSubject(rs.getString(6));
                timeSlot.setDate(rs.getString(3));
                timeSlot.setStartTime(rs.getString(4));
                timeSlot.setEndTime(rs.getString(5));
                timeSlot.setClassroom(rs.getInt(8));
                timeSlot.setTeacher(rs.getInt(7));

                System.out.println(timeSlot.getId());
                list.add(timeSlot);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean check(String start, String end, String classroom){

        boolean check = false;

        try {

            con = DBConnectionUtil.getConnection();
            String sql="select count (id)  from timeslot where classroom ='"+classroom+"'  and id in(select id from timeslot where starttime >='"+start+"' or endtime < '"+end+"' )";

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            System.out.println(rs.getString(1));



            if(rs.getString(1) != null){
                check =true;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return check;


    }
}
