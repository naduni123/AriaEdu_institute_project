package service;

import model.Batch;
import model.Classroom;
import model.Loading;
import model.TimeSlot;
import util.DBConnectionUtil;
import util.QueryTimeAndClass;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoadingService {

    Connection con;
    PreparedStatement preparedStatement;

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

            timeSlot.setSubject(rs.getString(6));
            timeSlot.setDate(rs.getString(3));
            timeSlot.setStartTime(rs.getString(4));
            timeSlot.setEndTime(rs.getString(5));
            timeSlot.setClassroom(rs.getInt(8));
            timeSlot.setBatch(rs.getInt(2));
            timeSlot.setId(rs.getInt(1));




        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }


      return timeSlot;
    }


}
