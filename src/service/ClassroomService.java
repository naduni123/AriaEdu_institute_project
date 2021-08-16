package service;

import model.Classroom;
import util.DBConnectionUtil;
import util.QueryTimeAndClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

            preparedStatement.setInt(1,classroom.getId());
            preparedStatement.setString(2,classroom.getName());
            preparedStatement.setString(3,classroom.getFloor());
            preparedStatement.setInt(4,classroom.getCapacity());
            preparedStatement.setString(5,classroom.getAc());



            System.out.println(sql);

            preparedStatement.execute();

        }catch(Exception e){

            e.printStackTrace();
        }

    }

    @Override
    public void editClassroom(Classroom classroom) {

    }

    @Override
    public ArrayList<Classroom> viewClassroom() {
        return null;
    }
}
