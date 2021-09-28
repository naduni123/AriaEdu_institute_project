package service;

import model.Classroom;
import util.DBConnectionUtil;
import util.QueryTimeAndClass;

import java.sql.*;
import java.util.ArrayList;

public class ClassroomService implements IClassroom {

    Connection con;
    PreparedStatement preparedStatement;


    @Override
    public void addClassroom(Classroom classroom) {

        try {
            con = DBConnectionUtil.getConnection();
            String sql = QueryTimeAndClass.ADD_CLASS;
            preparedStatement = con.prepareStatement(sql);
            System.out.println(sql);


            preparedStatement.setString(1,classroom.getName());
            preparedStatement.setString(2,classroom.getFloor());
            preparedStatement.setInt(3,classroom.getCapacity());
            preparedStatement.setString(4,classroom.getAc());



            System.out.println(sql);

            preparedStatement.execute();

        }catch(Exception e){

            e.printStackTrace();
        }

    }

    @Override
    public void editClassroom(Classroom classroom) {
        try {
            con = DBConnectionUtil.getConnection();
            String sql = QueryTimeAndClass.UPDATE_CLASS+classroom.getId();
            preparedStatement = con.prepareStatement(sql);
            System.out.println(sql);


            preparedStatement.setString(1,classroom.getName());
            preparedStatement.setString(2,classroom.getFloor());
            preparedStatement.setInt(3,classroom.getCapacity());
            preparedStatement.setString(4,classroom.getAc());



            System.out.println(sql);

            preparedStatement.execute();

        }catch(Exception e){

            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Classroom> viewClassroom() {

        ArrayList<Classroom> list = new ArrayList<>();

        try {

            con = DBConnectionUtil.getConnection();
            String sql=QueryTimeAndClass.SEE_CLASS;

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                int id =Integer.parseInt(rs.getString(1));
                String name= (rs.getString(2));
                String floor =rs.getString(3);
                int capacity =Integer.parseInt(rs.getString(4));
                String ac =rs.getString(5);


                Classroom classroom = new Classroom();

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

    @Override
    public boolean deleteClassroom(int id) {
        boolean rowdeleted = false;
        try {

            con = DBConnectionUtil.getConnection();
            String sql=QueryTimeAndClass.DELETE_CLASS+id;

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

             rowdeleted = preparedStatement.executeUpdate() >0;




        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
            return rowdeleted;
    }


    public Classroom findClassroom(int id){

        Classroom classroom =  new Classroom();

        try {

            con = DBConnectionUtil.getConnection();
            String sql=QueryTimeAndClass.FIND_CLASS+id;

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {

                classroom.setId(rs.getInt(1));
                classroom.setName(rs.getString(2));
                classroom.setFloor(rs.getString(3));
                classroom.setCapacity(rs.getInt(4));
                classroom.setAc(rs.getString(5));


                System.out.println("service" + classroom.getAc());

            } 


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return classroom;


    }


}
