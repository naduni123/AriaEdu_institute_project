package service;

import model.AttendanceMarker;
import model.Classroom;
import util.DBConnectionUtil;
import util.QueryAttendance;
import util.QueryTimeAndClass;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceMarkerService implements IAttendanceMarker{

    Connection con;
    PreparedStatement preparedStatement;

    @Override
    public void addAttendance(AttendanceMarker attendanceMarker) {

        try {
            con = DBConnectionUtil.getConnection();

            String sql = QueryAttendance.ADD_ATTENDANCE_MARKER;
            preparedStatement = con.prepareStatement(sql);
            System.out.println(sql);


            preparedStatement.setString(1,attendanceMarker.getFname());
            preparedStatement.setString(2,attendanceMarker.getLname());
            preparedStatement.setDate(3,attendanceMarker.getDob());
            preparedStatement.setString(4,attendanceMarker.getNic());
            preparedStatement.setString(5,attendanceMarker.getAddress());
            preparedStatement.setString(6,attendanceMarker.getGender());
            preparedStatement.setString(7,attendanceMarker.getPhone());
            preparedStatement.setString(8,attendanceMarker.getEmail());
            preparedStatement.setString(9,attendanceMarker.getTeacher());

            preparedStatement.execute();

            String[] temp = attendanceMarker.getSubject();

            for(String i :temp) {

                String sql2 = QueryAttendance.ADD_ATTEND_SUBJECT;
                preparedStatement = con.prepareStatement(sql2);

                preparedStatement.setString(1,attendanceMarker.getFname());
                preparedStatement.setString(2,attendanceMarker.getLname());
                preparedStatement.setString(3,i);

                preparedStatement.execute();

            }




        }catch(Exception e){

            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<AttendanceMarker> viewAttendMarkers() {


        ArrayList<AttendanceMarker> list = new ArrayList<>();

        try {

            con = DBConnectionUtil.getConnection();
            String sql = QueryAttendance.SEE_ATTEND_MARKERS;


            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                int id =Integer.parseInt(rs.getString(1));
                String name= (rs.getString(2)+" "+rs.getString(3));
                String teacher =rs.getString(10);

                String sql2 ="select * from attendsubject where fname='"+rs.getString(2)+"' AND " +
                        " lname='"+rs.getString(3)+"'";

                preparedStatement=con.prepareStatement(sql2);

                ResultSet rs2 = preparedStatement.executeQuery();

                String tempsubject="";
                while(rs2.next()){
                    System.out.println("in loop");
                    tempsubject =tempsubject+ rs2.getString(4)+" ";
                }

                AttendanceMarker marker = new AttendanceMarker();
                marker.setId(id);
                marker.setFname(name);
                marker.setList(tempsubject);
                marker.setTeacher(teacher);


                list.add(marker);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
