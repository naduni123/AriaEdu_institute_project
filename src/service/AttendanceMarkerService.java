package service;

import model.Attendance;
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

            int id =checknextid();
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

                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,attendanceMarker.getFname());
                preparedStatement.setString(3,attendanceMarker.getLname());
                preparedStatement.setString(4,i);

                preparedStatement.execute();

            }




        }catch(Exception e){

            e.printStackTrace();
        }
    }

    private int checknextid() {

        int id=0;

        try {
            con = DBConnectionUtil.getConnection();
            String sql = "SELECT * FROM attendancemarker ORDER BY ID DESC LIMIT 1";


            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();



            while(rs.next()){
              id=  rs.getInt(1);
            }

        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        return id+1;
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

                String sql2 ="select * from attendsubject where attid="+rs.getInt(1);

                preparedStatement=con.prepareStatement(sql2);

                ResultSet rs2 = preparedStatement.executeQuery();

                String tempsubject="";
                while(rs2.next()){
                    System.out.println("in loop");
                    tempsubject =tempsubject+ rs2.getString(5)+" ";
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

    @Override
    public AttendanceMarker findById(int id) {

        AttendanceMarker  attendanceMarker  = new AttendanceMarker();
        try {

            con = DBConnectionUtil.getConnection();
            String sql = QueryAttendance.FIND_ATT_MARKER+id;


            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                attendanceMarker.setId(rs.getInt(1));
                System.out.println("service"+attendanceMarker.getId());
                attendanceMarker.setFname(rs.getString(2));
                attendanceMarker.setLname(rs.getString(3));
                attendanceMarker.setAddress(rs.getString(6));
                attendanceMarker.setPhone(rs.getString(8));
                attendanceMarker.setEmail(rs.getString(9));
                attendanceMarker.setTeacher(rs.getString(10));
            }

        }catch (Exception e){

            e.printStackTrace();
        }


        return attendanceMarker;
    }

    @Override
    public void updateAttMarker(AttendanceMarker attendanceMarker) {


        try {
            con = DBConnectionUtil.getConnection();

            String sql = QueryAttendance.UPDATE_ATT_MARKER+attendanceMarker.getId();
            preparedStatement = con.prepareStatement(sql);
            System.out.println(sql);


            preparedStatement.setString(1,attendanceMarker.getFname());
            preparedStatement.setString(2,attendanceMarker.getLname());
            preparedStatement.setString(3,attendanceMarker.getAddress());
            preparedStatement.setString(4,attendanceMarker.getPhone());
            preparedStatement.setString(5,attendanceMarker.getEmail());
            preparedStatement.setString(6,attendanceMarker.getTeacher());

            preparedStatement.execute();

        }catch(Exception e){

            e.printStackTrace();
        }
    }

    @Override
    public boolean delteAttMarker(int id) {

        boolean rowDeleted = false;
        try {

            con = DBConnectionUtil.getConnection();
            String sql=QueryAttendance.DELETE_ATT_MARKER+id;
            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);


            //use to update the query
            rowDeleted = preparedStatement.executeUpdate() > 0;//return number of rows deleted
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
