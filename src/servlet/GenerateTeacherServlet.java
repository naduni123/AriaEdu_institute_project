package servlet;

import service.TimeSlotService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GenerateTeacherServlet")
public class GenerateTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("teacher"));
        try{
            TimeSlotService service = new TimeSlotService();
            service.teacherPdf(id);
            response.sendRedirect("timetablegenerator.jsp");

        }catch (Exception e){

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
