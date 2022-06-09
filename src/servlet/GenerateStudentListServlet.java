package servlet;

import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Servlet implementation class GenerateStudentListServlet
@WebServlet("/GenerateStudentListServlet")
public class GenerateStudentListServlet extends HttpServlet {
    //@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    //@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Create an object
        StudentService studentService = new StudentService();
        try{
            //Call generatePDF function in studentService
            studentService.generatePDF();
            //Direct to view_student_profile page
            response.sendRedirect("view_student_details.jsp");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
