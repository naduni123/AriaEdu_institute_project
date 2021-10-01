package servlet;

import model.Classroom;
import service.ClassroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//RETIREVE CLASSROOM TO UPDATE FORM
@WebServlet("/RetrieveClassroomToUpdateServlet")
public class RetrieveClassroomToUpdateServlet extends HttpServlet {

    ClassroomService classroomService = new ClassroomService();
    Classroom classroom = new Classroom();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        classroom = classroomService.findClassroom(id);

        System.out.println(classroom.getName() + " fdgdfgdf");

        request.setAttribute("id", classroom.getId());
        request.setAttribute("name", classroom.getName());
        request.setAttribute("floor", classroom.getFloor());
        request.setAttribute("capacity", classroom.getCapacity());
        request.setAttribute("ac", classroom.getAc());
        request.getRequestDispatcher("update_classroom.jsp").forward(request, response);
    }
}
