package servlet;

import model.Student;
import service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Servlet implementation class RetrieveStudent
@WebServlet("/RetrieveStudent")
public class RetrieveStudent extends HttpServlet {
    public RetrieveStudent() {
        super();
    }

    //Create an object
    StudentService studentService= new StudentService();

    //@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    //@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get Student ID
        int id = Integer.parseInt(request.getParameter("id"));

        //Declare a variable
        Student existingStudent;
        try {
            //Call selectStudent function in studentService
            existingStudent = studentService.selectStudent(id);
            //Set id to selectStudent function
            existingStudent.setId(id);

            //Direct to update_student_details page
            RequestDispatcher dispatcher = request.getRequestDispatcher("update_student_details.jsp");
            request.setAttribute("student", existingStudent);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
