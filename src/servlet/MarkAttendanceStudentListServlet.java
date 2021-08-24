package servlet;

import model.Attendance;
import model.Student;
import service.AttendanceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/MarkAttendanceStudentListServlet")
public class MarkAttendanceStudentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String batch =(request.getParameter("batch"));
       String subject = request.getParameter("subject");

        AttendanceService service = new AttendanceService();
        ArrayList<Student> list =service.viewbySubject(subject,batch);

        request.setAttribute("list",list);
        response.sendRedirect("marke_attendance.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
