package servlet;

import model.Classroom;
import service.ClassroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddClassroomServlet")
public class AddClassroomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String name=request.getParameter("name");
        String floor=request.getParameter("floor");
        int capacity= Integer.parseInt(request.getParameter("capacity"));
        String ac=request.getParameter("ac");

        Classroom classroom = new Classroom(){};

        classroom.setName(name);
        classroom.setFloor(floor);
        classroom.setCapacity(capacity);
        classroom.setAc(ac);

        ClassroomService classroomService = new ClassroomService();
        classroomService.addClassroom(classroom);
        response.sendRedirect("indexhome.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
