package servlet;

import model.Attendance;
import service.AttendanceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/AddAttendanceServlet")
public class AddAttendanceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Attendance attendance =new Attendance();
        System.out.println(request.getParameter("sid"));
        attendance.setId(Integer.parseInt(request.getParameter("sid")));
        System.out.println("servlet "+attendance.getId());
        attendance.setStatus(Integer.parseInt(request.getParameter("status")));

        AttendanceService service = new AttendanceService();
        service.addAttendance(attendance);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
