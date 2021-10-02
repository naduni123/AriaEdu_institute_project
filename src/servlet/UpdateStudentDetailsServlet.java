package servlet;

import model.Student;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Servlet implementation class UpdateStudentDetailsServlet
@WebServlet("/UpdateStudentDetailsServlet")
public class UpdateStudentDetailsServlet extends HttpServlet {
    //Create an Object
    StudentService studentService = new StudentService();

    //@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Create an Object
        Student student = new Student();

        //Get data sent from update_student_details jsp file and set them
        student.setId(Integer.parseInt(request.getParameter("id")));
        student.setAddress(request.getParameter("address"));
        student.setPhone(Integer.parseInt(request.getParameter("phone")));
        student.setEmail(request.getParameter("email"));
        student.setStatus(request.getParameter("status"));

        //Call editStudent function in studentService
        studentService.editStudent(student);
        //Direct to view_student_details page
        response.sendRedirect("view_student_details.jsp");
    }

    //@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
