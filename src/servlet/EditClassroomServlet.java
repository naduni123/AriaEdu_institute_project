package servlet;

import model.Classroom;
import service.ClassroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//EDIT CLASSROOM
@WebServlet( "/EditClassroomServlet")
public class EditClassroomServlet extends HttpServlet {
    ClassroomService  classroomService  = new ClassroomService();
    Classroom classroom = new Classroom();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name=request.getParameter("name");
        String floor=request.getParameter("floor");
        int capacity= Integer.parseInt(request.getParameter("capacity"));
        String ac=request.getParameter("ac");

        Classroom classroom = new Classroom(){};

        classroom.setId(Integer.parseInt(request.getParameter("id")));
        classroom.setName(name);
        classroom.setFloor(floor);
        classroom.setCapacity(capacity);
        classroom.setAc(ac);

        ClassroomService classroomService = new ClassroomService();
        classroomService.editClassroom(classroom);
        response.sendRedirect("classroomlist.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
