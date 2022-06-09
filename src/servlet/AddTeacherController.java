package servlet;


import com.google.gson.Gson;
import model.Teacher;
import model.TeacherModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/AddTeacherController")
public class AddTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacherController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String action = request.getParameter("action"); //check action
		PrintWriter out = response.getWriter();
		Gson json = new Gson(); //used to pass data with js
		//add teachers
		if(action.equalsIgnoreCase("add")) {
			Teacher teacher = new Teacher(); //create object
			teacher.setF_name(request.getParameter("f_name"));
			teacher.setL_name(request.getParameter("l_name"));
			teacher.setFull_name(request.getParameter("full_name"));
			teacher.setGender(request.getParameter("gender"));
			teacher.setNic(request.getParameter("nic"));
			teacher.setAddress(request.getParameter("address"));
			teacher.setContact_no(request.getParameter("phone"));
			teacher.setEmail(request.getParameter("email"));
			teacher.setSubject(request.getParameter("subject"));
			int state = TeacherModel.registerTeacher(teacher);
			out.print(json.toJson(state));
			out.flush();
			out.close();
		//add qualifications
		}else if(action.equalsIgnoreCase("addTeacherQualification")){
			int teacherId = Integer.parseInt(request.getParameter("id"));
			String description = request.getParameter("qualification");

			int state = TeacherModel.addTeacherQualification(teacherId, description);

			if(state!= 0) {
				System.out.println("Succesfully Inserted to teacher qualification!");
				out.print(json.toJson(true));
				out.flush();
				out.close();
			}else {
				System.out.println("Error in Insert to teacher qualification!");
				out.print(json.toJson(false));
				out.flush();
				out.close();
		//read values	}
		}else if(action.equalsIgnoreCase("get")) {
			String description = request.getParameter("txt");
			String subject = request.getParameter("subject");
			String status = request.getParameter("status");
			ArrayList<Teacher> all_teacher = TeacherModel.retrieveAllTeachers(description,subject,status);
			out.print(json.toJson(all_teacher));
			out.flush();


		}else if(action.equalsIgnoreCase("qualification")) {
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<String> all_teacher = TeacherModel.retrieveAllTeachersQualifications(id);
			out.print(json.toJson(all_teacher));
			out.flush();
			out.close();
		}else if(action.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			boolean state = TeacherModel.deleteTeacher(id);
			out.print(json.toJson(state));
			out.flush();
			out.close();
		}else if(action.equalsIgnoreCase("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int status = Integer.parseInt(request.getParameter("status")) == 1 ? 0: 1;
			boolean state = TeacherModel.changeTeacherStatus(id, status);
			out.print(json.toJson(state));
			out.flush();
			out.close();

		}else if(action.equalsIgnoreCase("update_teacher")) {
			Teacher teacher = new Teacher();
			int id = Integer.parseInt(request.getParameter("id"));
			teacher.setF_name(request.getParameter("f_name"));
			teacher.setL_name(request.getParameter("l_name"));
			teacher.setFull_name(request.getParameter("full_name"));
			teacher.setAddress(request.getParameter("address"));
			teacher.setEmail(request.getParameter("email"));
			teacher.setSubject(request.getParameter("subject"));
			boolean state = TeacherModel.changeTeacherDetails(id,teacher);
			out.print(json.toJson(state));
			out.flush();
			out.close();

		}
	}

}
