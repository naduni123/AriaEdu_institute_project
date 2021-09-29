package servlet;

import model.Student;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
    public StudentListServlet() {
        super();
    }

    //Create an Object
    StudentService studentService= new StudentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Call service Method
        ArrayList<Student> list = new ArrayList<>();
        try{
            list = studentService.ViewStudent();

            request.setAttribute("list",list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}