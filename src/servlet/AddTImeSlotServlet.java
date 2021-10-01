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

//ADD TIMESLOT
@WebServlet("/AddTImeSlotServlet")
public class AddTImeSlotServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TimeSlot timeSlot = new TimeSlot();
        TimeSlotService timeSlotService = new TimeSlotService();

        timeSlot.setBatch(Integer.parseInt(request.getParameter("batch")));
        timeSlot.setDate(request.getParameter("day"));

        String start = request.getParameter("starttime");
        String end = request.getParameter("endtime");
        String classroom = request.getParameter("classroom");

        boolean check = timeSlotService.check(start,end,classroom);
        System.out.println(check);

        if(check == false) {

            timeSlot.setBatch(Integer.parseInt(request.getParameter("batch")));
            timeSlot.setDate(request.getParameter("day"));
            timeSlot.setStartTime(request.getParameter("starttime"));
            timeSlot.setEndTime(request.getParameter("endtime"));
            timeSlot.setSubject(request.getParameter("subject"));
            timeSlot.setTeacher(Integer.parseInt(request.getParameter("teacher")));
            timeSlot.setClassroom(Integer.parseInt(request.getParameter("classroom")));


            timeSlotService.AddTimeSlot(timeSlot);
            response.sendRedirect("timetabledashboard.jsp");

        }else{
            response.sendRedirect("add_time_slot.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
