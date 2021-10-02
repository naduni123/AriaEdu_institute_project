package servlet;

import model.Student;
import util.DBConnectionUtil;
import util.QueryStudent;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Servlet implementation class SearchStudentDetailsDServlet
@WebServlet("/SearchStudentDetailsTxtServlet")
public class SearchStudentDetailsTxtServlet extends HttpServlet{
    public SearchStudentDetailsTxtServlet() {
        super();
    }

    //@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    //@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get Name, NIC, Phone or NIC
        String a = request.getParameter("txt");
        //SQL QUERY (RETRIEVE)
        String sql = "SELECT * FROM studentdetails WHERE (firstName LIKE '%"+a+"%' OR lastName LIKE '%"+a+"%' OR nic LIKE '%"+a+"%' OR phone LIKE '%"+a+"%')";

        //declare Variable
        Connection con = null;
        //Create a new ArrayList
        ArrayList<Student> list = new ArrayList<>();
        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //Create a statement using connection object
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            //Execute the query
            ResultSet rs = preparedStatement.executeQuery();

            //Process the ResultSet object
            while (rs.next()) {
                //Get values to Student Details Table
                int id = Integer.parseInt(rs.getString(1));
                String name = (rs.getString(2) + " " + rs.getString(3));
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String batch = rs.getString(11);
                String status = rs.getString(12);

                //SQL QUERY (RETRIEVE)
                String sql2 = QueryStudent.SEE_STUDENT_SUBJECTS;
                //Create a statement using connection object
                preparedStatement = con.prepareStatement(sql2);
                //Get data and Add data to PreparedStatement
                preparedStatement.setString(1, rs.getString(2));
                preparedStatement.setString(2, rs.getString(3));

                //Execute the query
                ResultSet rs2 = preparedStatement.executeQuery();

                //Declare and assign value
                String tempsubject = "";

                //Process the ResultSet object
                while (rs2.next()) {
                    //Get Subjects
                    tempsubject = tempsubject + rs2.getString(3) + " ";
                }

                //Create an Object
                Student student = new Student();

                //Retrieve Student Details from studentdetails table(DB) & studentlearnsubject table(DB)
                student.setId(id);
                student.setFullName(name);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setBatch(batch);
                student.setList(tempsubject);
                student.setStatus(status);

                list.add(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("txt",list);
        //Direct to view_student_details page
        RequestDispatcher view = request.getRequestDispatcher("view_student_details.jsp");
        view.forward(request, response);
    }
}
