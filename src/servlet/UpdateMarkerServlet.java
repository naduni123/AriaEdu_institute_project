package servlet;

import model.AttendanceMarker;
import service.AttendanceMarkerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/UpdateMarkerServlet")
public class UpdateMarkerServlet extends HttpServlet {
    AttendanceMarker attendanceMarker = new AttendanceMarker();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AttendanceMarker attendanceMarker = new AttendanceMarker();

        attendanceMarker.setId(Integer.parseInt(request.getParameter("id")));
        attendanceMarker.setFname(request.getParameter("fname"));
        attendanceMarker.setLname(request.getParameter("lname"));
        attendanceMarker.setAddress(request.getParameter("address"));
        attendanceMarker.setPhone(request.getParameter("phone"));
        attendanceMarker.setEmail(request.getParameter("email"));
        attendanceMarker.setTeacher(request.getParameter("teacher"));


        AttendanceMarkerService service = new AttendanceMarkerService();
        service.updateAttMarker(attendanceMarker);
        response.sendRedirect("attendance_markers_list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
