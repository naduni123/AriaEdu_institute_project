package servlet;

import service.ClassroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//DELETE CLASSROOM
@WebServlet("/DeleteClassroomServlet")
public class DeleteClassroomServlet extends HttpServlet {
    ClassroomService service = new ClassroomService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id  = Integer.parseInt(request.getParameter("id"));
        service.deleteClassroom(id);

        response.sendRedirect("classroomlist.jsp");
    }
}
