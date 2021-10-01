package servlet;

import model.Classroom;
import service.ClassroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//RETRIEVE CLASS ROOM LIST
@WebServlet("/ClassroomListServlet")
public class ClassroomListServlet extends HttpServlet {

    ClassroomService classroomService= new ClassroomService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<Classroom> list = new ArrayList<>();
            try{
                list = classroomService.viewClassroom();

                request.setAttribute("list",list);

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
