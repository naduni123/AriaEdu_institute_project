package servlet;

import model.TimeSlot;
import service.LoadingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RetrieveToUpdateServlet")
public class RetrieveToUpdateServlet extends HttpServlet {

    LoadingService service = new LoadingService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("slotid"));
        TimeSlot timeSlot = service.RetrieveTimeSlot(id);

        request.setAttribute("slotId",id);
        request.setAttribute("slotBatch",timeSlot.getBatch());
        request.setAttribute("slotDate",timeSlot.getDate());
        request.setAttribute("slotStime",timeSlot.getStartTime());
        request.setAttribute("slotEtime",timeSlot.getEndTime());
        request.setAttribute("slotSub",timeSlot.getSubject());
        request.setAttribute("slotTeacher",timeSlot.getTeacher());
        request.setAttribute("slotClass",timeSlot.getClassroom());

        request.getRequestDispatcher("update_time_slot.jsp").forward(request,response);


    }
}
