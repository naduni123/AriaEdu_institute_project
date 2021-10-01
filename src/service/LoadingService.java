package service;

//imports
import model.Batch;
import model.Classroom;
import model.Loading;
import model.TimeSlot;
import util.DBConnectionUtil;
import util.QueryTimeAndClass;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;

public class LoadingService {

    Connection con;
    PreparedStatement preparedStatement;

   //VIEW BATCH
  public ArrayList<Batch> viewBatch(){

      ArrayList<Batch> list = new ArrayList<>();

      try {

          con = DBConnectionUtil.getConnection();
          String sql= QueryTimeAndClass.SEE_BATCH;

          preparedStatement = con.prepareStatement(sql);
          System.out.println(preparedStatement);

          ResultSet rs = preparedStatement.executeQuery();

          while (rs.next()) {

              Batch batch = new Batch();

              batch.setId(rs.getInt(1));
              batch.setName(rs.getString(2));

              list.add(batch);
          }
      } catch (ClassNotFoundException | SQLException e) {
          e.printStackTrace();
      }
      return list;

  }

    //VIEW TEACHER
  public ArrayList<Loading> viewTeacher(){

      ArrayList<Loading> list = new ArrayList<>();

      try {

          con = DBConnectionUtil.getConnection();
          String sql= QueryTimeAndClass.SEE_TEACHERS;

          preparedStatement = con.prepareStatement(sql);
          System.out.println(preparedStatement);

          ResultSet rs = preparedStatement.executeQuery();

          while (rs.next()) {

              Loading loading = new Loading();

              loading.setTeacherId(rs.getInt(1));
              loading.setTeacherName(rs.getString(2));

              list.add(loading);
          }
      } catch (ClassNotFoundException | SQLException e) {
          e.printStackTrace();
      }
      return list;



  }

  //FIND TEACHER
  public String findTeacher(int id){

      String name=" ";

      try{

          con = DBConnectionUtil.getConnection();
          String sql= QueryTimeAndClass.FIND_TEACHER+id;

          preparedStatement = con.prepareStatement(sql);
          System.out.println(preparedStatement);

          ResultSet rs = preparedStatement.executeQuery();

          name= rs.getString(2);




      }
      catch (ClassNotFoundException | SQLException e){
          e.printStackTrace();
      }

      return  name;
  }

    //FIND BATCH
    public String findBatch(int id){

        String name=" ";

        try{

            con = DBConnectionUtil.getConnection();
            String sql= QueryTimeAndClass.FIND_BATCH+id;

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            name= rs.getString(2);
            System.out.println(name);


        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        return  name;
    }

    //FIND CLASS
    public String findClass(int id){

        String name=" ";

        try{

            con = DBConnectionUtil.getConnection();
            String sql= QueryTimeAndClass.FIND_CLASS+id;

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            name= rs.getString(2);



        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        return  name;
    }


    public TimeSlot RetrieveTimeSlot(int id){

      TimeSlot timeSlot = new TimeSlot();
        try{

            con = DBConnectionUtil.getConnection();
            String sql= QueryTimeAndClass.FIND_TIME+id;

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                timeSlot.setSubject(rs.getString(6));
                timeSlot.setDate(rs.getString(3));
                timeSlot.setStartTime(rs.getString(4));
                timeSlot.setEndTime(rs.getString(5));
                timeSlot.setClassroom(rs.getInt(8));
                timeSlot.setBatch(rs.getInt(2));
                timeSlot.setId(rs.getInt(1));
            }



        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }


      return timeSlot;
    }

    public ArrayList<Classroom> status(String day , Time start , Time end){

        ArrayList<Classroom> list = new ArrayList<>();

        try {

            con = DBConnectionUtil.getConnection();
            String sql="select c.name , c.floor , c.capacity ,c.ac from class c ,timeslot t where t.id not in (select b.id from timeslot b b.day =? and b.starttime between ? and ? and b.enddtime between ? and ?)";

            preparedStatement = con.prepareStatement(sql);


            preparedStatement.setString(1,day);
            preparedStatement.setTime(2,start);
            preparedStatement.setTime(3,end);
            preparedStatement.setTime(4,start);
            preparedStatement.setTime(5,end);

            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                int id =Integer.parseInt(rs.getString(1));
                System.out.println(id);
                String name= (rs.getString(2));
                String floor =rs.getString(3);
                int capacity =Integer.parseInt(rs.getString(4));
                String ac =rs.getString(5);


                Classroom classroom = new Classroom();

                System.out.println(id);

                classroom.setId(id);
                classroom.setName(name);
                classroom.setFloor(floor);
                classroom.setCapacity(capacity);
                classroom.setAc(ac);


                list.add(classroom);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;





    }


}
