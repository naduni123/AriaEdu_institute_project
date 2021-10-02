package servlet;

import model.Student;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

//Servlet implementation class AddStudentServlet
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    public AddStudentServlet() {
        super();
    }

    //@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Create an Object
        Student student = new Student();

        //Get data sent from jsp file and set them
        student.setFirstName(request.getParameter("firstName"));
        student.setLastName(request.getParameter("lastName"));
        student.setGender(request.getParameter("gender"));
        student.setDob(Date.valueOf(request.getParameter("dob")));
        student.setNic(request.getParameter("nic"));
        student.setAddress(request.getParameter("address"));
        student.setPhone(Integer.parseInt(request.getParameter("phone")));
        student.setEmail(request.getParameter("email"));
        student.setAdmissionDate(Date.valueOf(request.getParameter("admissionDate")));
        student.setBatch(request.getParameter("batch"));
        student.setSubject(request.getParameterValues("subject"));

        //Create an Object
        StudentService studentService = new StudentService();

        //Call addStudent function in studentService
        studentService.addStudent(student);
        //Direct to view_student_details page
        response.sendRedirect("view_student_details.jsp");
    }

    //@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
