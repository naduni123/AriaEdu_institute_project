package servlet;

import model.AttendanceMarker;
import service.AttendanceMarkerService;
import service.ClassroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

@WebServlet("/AddAttendanceMarkerServlet")
public class AddAttendanceMarkerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AttendanceMarker attendanceMarker = new AttendanceMarker();

        attendanceMarker.setFname(request.getParameter("fname"));
        attendanceMarker.setLname(request.getParameter("lname"));
        attendanceMarker.setDob(Date.valueOf(request.getParameter("dob")));
        attendanceMarker.setNic(request.getParameter("nic"));
        attendanceMarker.setAddress(request.getParameter("address"));
        attendanceMarker.setGender(request.getParameter("gender"));
        attendanceMarker.setPhone(request.getParameter("phone"));
        attendanceMarker.setEmail(request.getParameter("email"));
        attendanceMarker.setTeacher(request.getParameter("teacher"));
        attendanceMarker.setSubject(request.getParameterValues("subject"));

        AttendanceMarkerService service = new AttendanceMarkerService();
        service.addAttendance(attendanceMarker);
        response.sendRedirect("indexhome.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
