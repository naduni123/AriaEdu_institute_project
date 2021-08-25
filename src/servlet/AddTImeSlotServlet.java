package servlet;

import model.Classroom;
import model.TimeSlot;
import service.ClassroomService;
import service.TimeSlotService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;

@WebServlet("/AddTImeSlotServlet")
public class AddTImeSlotServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TimeSlot timeSlot = new TimeSlot();

        timeSlot.setBatch(Integer.parseInt(request.getParameter("batch")));
        timeSlot.setDate(request.getParameter("day"));
        System.out.println(request.getParameter("starttime"));
        timeSlot.setStartTime(request.getParameter("starttime"));
        timeSlot.setEndTime(request.getParameter("endtime"));
        timeSlot.setSubject(request.getParameter("subject"));
        timeSlot.setTeacher(Integer.parseInt(request.getParameter("teacher")));
        timeSlot.setClassroom(Integer.parseInt(request.getParameter("classroom")));

        TimeSlotService timeSlotService = new TimeSlotService();
        timeSlotService.AddTimeSlot(timeSlot);
        response.sendRedirect("indexhome.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
