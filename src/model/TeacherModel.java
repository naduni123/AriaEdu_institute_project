package model;

import util.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherModel {

	public static int registerTeacher(Teacher teacher) {
		String sql1 = "select max(idteacher) as max from teacher";
		Connection con = DataAccess.connect(); //db connection
		int max_id=1;
		try {
			PreparedStatement ps = con.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();

			if (rs.first()) {
				String sql = "insert into teacher values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps1 = con.prepareStatement(sql);
				max_id=rs.getInt("max");
				max_id++;
				ps1.setInt(1, max_id);
				ps1.setString(2, teacher.getF_name());
				ps1.setString(3, teacher.getL_name());
				ps1.setString(4, teacher.getFull_name());
				ps1.setString(5, teacher.getGender());
				ps1.setString(6, teacher.getNic());
				ps1.setString(7, teacher.getAddress());
				ps1.setString(8, teacher.getContact_no());
				ps1.setString(9, teacher.getEmail());
				ps1.setString(10, teacher.getSubject());
				ps1.setInt(11, 1);

				ps1.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return max_id;

	}

	public static int addTeacherQualification(int teacherId, String description) {

		int i = 0;
		Connection con = DataAccess.connect();
		String sql = "insert into teacher_qualification values(?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, null); //autoincrement
			ps.setInt(2, teacherId);
			ps.setString(3, description);
			i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;

	}

	public static ArrayList<Teacher> retrieveAllTeachers(String txt,String subject,String status){
		ArrayList<Teacher> teachers = new ArrayList<>();
		Teacher teacher = null;

		Connection con = DataAccess.connect();
		String sql = "select * from teacher where (full_name like '%"+txt+"%' or nic like '%"+txt+"%'  or contact_no like '%"+txt+"%')";
		if (status.equals("all")){ //if status is all
			if (subject.equals("all")){//if subject is all

			}else{//if subject is not all
				sql = sql + " and subject='"+subject+"'";
			}
		}else { //if status is not 'all'
			if (subject.equals("all")){//if subject is all
				sql = sql + " and status='"+status+"'";
			}else{ //if subject is not all
				sql = sql + " and status='"+status+"' and subject='"+subject+"'";
			}

		}
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet resultset = ps.executeQuery();

			while(resultset.next()) {
				teacher = new Teacher();
				teacher.setId(resultset.getInt("idteacher"));
				teacher.setF_name(resultset.getString("f_name"));
				teacher.setL_name(resultset.getString("l_name"));
				teacher.setFull_name(resultset.getString("full_name"));
				teacher.setGender(resultset.getString("gender"));
				teacher.setNic(resultset.getString("nic"));
				teacher.setAddress(resultset.getString("address"));
				teacher.setContact_no(resultset.getString("contact_no"));
				teacher.setEmail(resultset.getString("email"));
				teacher.setSubject(resultset.getString("subject"));
				teacher.setStatus(resultset.getInt("status"));
				teachers.add(teacher);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return teachers;

	}

	public static ArrayList<String> retrieveAllTeachersQualifications(int id){
		ArrayList<String> teachers = new ArrayList<>();
		Connection con = DataAccess.connect();
		String sql = "select * from teacher_qualification where teacher_id="+id+"";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet resultset = ps.executeQuery();
			String qualification="";
			while(resultset.next()) {
				qualification=resultset.getString("qualification");
				teachers.add(qualification);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teachers;

	}

	public static boolean changeTeacherStatus(int id, int status) {
		Connection connection = DataAccess.connect();
		//sql
		String sqlUpdate = "update teacher set status=? where idteacher=?";

		//execute
		try {
			//ps
			PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);
			psUpdate.setInt(1, status);
			psUpdate.setInt(2, id);
			psUpdate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static boolean changeTeacherDetails(int id, Teacher teacher) {
		Connection connection = DataAccess.connect();
		//sql
		String sqlUpdate = "update teacher set f_name=?,l_name=?,full_name=?,address=?,email=?,subject=? where idteacher=?";

		//execute
		try {
			//ps
			PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);
			psUpdate.setString(1, teacher.getF_name());
			psUpdate.setString(2, teacher.getL_name());
			psUpdate.setString(3, teacher.getFull_name());
			psUpdate.setString(4, teacher.getAddress());
			psUpdate.setString(5, teacher.getEmail());
			psUpdate.setString(6, teacher.getSubject());
			psUpdate.setInt(7, id);
			psUpdate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static boolean deleteTeacher(int id) {
		Connection connection = DataAccess.connect();
		//sql
		String sqlUpdate = "delete from teacher where idteacher=?";
		//execute
		try {
			//ps
			PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);

			psUpdate.setInt(1, id);

			psUpdate.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
