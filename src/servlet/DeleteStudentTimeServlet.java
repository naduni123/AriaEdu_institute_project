package servlet;

import service.TimeSlotService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//DELETE STUDENT TIME TABLE
@WebServlet("/DeleteStudentTimeServlet")
public class DeleteStudentTimeServlet extends HttpServlet {
    TimeSlotService timeSlotService = new TimeSlotService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        timeSlotService.deleteTime(id);

        request.getRequestDispatcher("studenttimetable.jsp").forward(request,response);
    }
}