package servlet;

import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Servlet implementation class DeleteStudentServlet
@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    //Create an Object
    StudentService service = new StudentService();

    //@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    //@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Get Student ID, First Name & Last Name
            int id = Integer.parseInt(request.getParameter("getId"));
            String firstName = request.getParameter("getFirstName");
            String lastName = request.getParameter("getLastName");

            //Call deleteStudent function in studentService
            service.deleteStudent(id, firstName, lastName);
            //Direct to view_student_details page
            response.sendRedirect("view_student_details.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
