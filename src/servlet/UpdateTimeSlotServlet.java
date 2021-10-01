package servlet;

import model.TimeSlot;
import service.TimeSlotService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//EDIT TIMESLOT
@WebServlet("/UpdateTimeSlotServlet")
public class UpdateTimeSlotServlet extends HttpServlet {

    TimeSlot timeSlot = new TimeSlot();
    TimeSlotService timeSlotService = new TimeSlotService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        timeSlot.setBatch(Integer.parseInt(request.getParameter("batch")));
        timeSlot.setDate(request.getParameter("day"));
        timeSlot.setStartTime(request.getParameter("starttime"));
        timeSlot.setEndTime(request.getParameter("endtime"));
        timeSlot.setSubject(request.getParameter("subject"));
        timeSlot.setTeacher(Integer.parseInt(request.getParameter("teacher")));
        timeSlot.setClassroom(Integer.parseInt(request.getParameter("classroom")));


        timeSlotService.UpdateTimeSlot(timeSlot);
        response.sendRedirect("timetabledashboard.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
