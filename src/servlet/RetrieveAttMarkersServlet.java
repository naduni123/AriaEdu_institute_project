package servlet;

import model.AttendanceMarker;
import model.Classroom;
import service.AttendanceMarkerService;

import javax.accessibility.AccessibleText;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RetrieveAttMarkersServlet")
public class RetrieveAttMarkersServlet extends HttpServlet {

    AttendanceMarkerService service = new AttendanceMarkerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AttendanceMarker> list = new ArrayList<>();
        try{
            list = service.viewAttendMarkers();

            request.setAttribute("list",list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
