package servlet;

import model.Attendance;
import service.AttendanceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@WebServlet( "/AddAttendanceServlet")
public class AddAttendanceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Attendance attendance = new Attendance();
        PreparedStatement preparedStatement;
        System.out.println(request.getParameter("sid"));
        attendance.setId(Integer.parseInt(request.getParameter("sid")));
        System.out.println("servlet " + attendance.getId());
        String temp = request.getParameter("status");
        attendance.setBatch(request.getParameter("batch"));
        System.out.println(attendance.getBatch());

        attendance.setSubject(request.getParameter("subject"));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date(System.currentTimeMillis());

        attendance.setTimestamp(date);

        if (temp == null) {
            attendance.setStatus(0);
        } else{
            attendance.setStatus(Integer.parseInt(request.getParameter("status")));
    }
        AttendanceService service = new AttendanceService();
        service.addAttendance(attendance);
        response.sendRedirect("marke_attendance.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
