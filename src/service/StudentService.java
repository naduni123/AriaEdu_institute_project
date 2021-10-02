package service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.Student;
import util.DBConnectionUtil;
import util.QueryStudent;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class StudentService implements IStudent{
    //declare Variables
    Connection con;
    PreparedStatement preparedStatement;

    //Add Student
    @Override
    public void addStudent(Student student) {
        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //SQL QUERY (INSERT)
            String sql = QueryStudent.ADD_STUDENT;
            //Create a statement using connection object
            preparedStatement = con.prepareStatement(sql);

            //Get data from form inputs and Add data to PreparedStatement
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getGender());
            preparedStatement.setDate(4, student.getDob());
            preparedStatement.setString(5, student.getNic());
            preparedStatement.setString(6, student.getAddress());
            preparedStatement.setInt(7, student.getPhone());
            preparedStatement.setString(8, student.getEmail());
            preparedStatement.setDate(9, student.getAdmissionDate());
            preparedStatement.setString(10, student.getBatch());

            //Execute Query (It will return the number of affected rows)
            preparedStatement.execute();

            //Declare a temp variable and assign values
            String[] temp = student.getSubject();

            for (String i : temp) {
                //SQL QUERY (INSERT)
                String sql2 = QueryStudent.ADD_STUDENT_SUBJECT;
                //Create a statement using connection object
                preparedStatement = con.prepareStatement(sql2);

                //Get subjects from form inputs and Add data to PreparedStatement
                preparedStatement.setString(1, student.getFirstName());
                preparedStatement.setString(2, student.getLastName());
                preparedStatement.setString(3, i);

                //Execute Query (It will return the number of affected rows)
                preparedStatement.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Update Student Details
    @Override
    public void editStudent(Student student) {
        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //SQL QUERY (UPDATE)
            String sql = QueryStudent.UPDATE_STUDENT_DETAILS+student.getId();
            //Create a statement using connection object
            preparedStatement = con.prepareStatement(sql);

            //Get data from update form inputs and Add data to PreparedStatement
            preparedStatement.setString(1, student.getAddress());
            preparedStatement.setInt(2, student.getPhone());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getStatus());

            //Update Query (It will return the number of affected rows)
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Delete Student
    @Override
    public boolean deleteStudent(int id, String firstName, String lastName) {
        //Declare variables and assign to false
        boolean rowDeleted1 = false;
        boolean rowDeleted2 = false;
        boolean rowDeleted3 = false;

        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //SQL QUERIES (DELETE)
            String sql= QueryStudent.DELETE_STUDENT;
            String sql2= QueryStudent.DELETE_SUBJECT;

            //Create a statement using connection object
            preparedStatement = con.prepareStatement(sql);
            //Get id and set id to PreparedStatement
            preparedStatement.setInt(1, id);

            //Use to update the query
            rowDeleted1 = preparedStatement.executeUpdate() > 0;//return number of rows deleted

            //Create a statement using connection object
            preparedStatement = con.prepareStatement(sql2);
            //Get firstName & lastName and set firstName & lastName to PreparedStatement
            preparedStatement.setString(1, "firstName");
            preparedStatement.setString(2, "lastName");

            //Use to update the query
            rowDeleted2 = preparedStatement.executeUpdate() > 0;//return number of rows deleted

            if ((rowDeleted1 == true) && (rowDeleted2 == true)){
                rowDeleted3 = true;
            }
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rowDeleted3;
    }

    //Select All Students
    @Override
    public ArrayList<Student> ViewStudent() {
        //using try-with-resources to avoid closing resources (boiler plate code)
        ArrayList<Student> list = new ArrayList<>();
        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //SQL QUERY (RETRIEVE)
            String sql = QueryStudent.SEE_ALL_STUDENT;
            //Create a statement using connection object
            preparedStatement = con.prepareStatement(sql);
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
                preparedStatement.setString(1,rs.getString(2));
                preparedStatement.setString(2,rs.getString(3));

                //Execute the query
                ResultSet rs2 = preparedStatement.executeQuery();

                //Declare and assign value
                String tempsubject="";
                //Process the ResultSet object
                while(rs2.next()){
                    //Get Subjects
                    tempsubject = tempsubject+ rs2.getString(3)+" ";
                }

                //Create an Object
                Student student = new Student();

                //Retrieve Student Details from studentdetails table(DB) & studentlearnsubject table(DB)
                student.setId(id);
                student.setFullName(name);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setFullName(name);
                student.setBatch(batch);
                student.setList(tempsubject);
                student.setStatus(status);

                list.add(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //Select student by id
    @Override
    public Student selectStudent(int id) {
        //Declare a variable and assign to null
        Student student = null;
        try {
            //Establishing a Connection
            con = DBConnectionUtil.getConnection();
            //SQL QUERY (RETRIEVE)
            String sql = QueryStudent.SEE_STUDENT_BY_STUDENTID;
            //Create a statement using connection object
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            //Execute the query
            ResultSet rs = preparedStatement.executeQuery();

            //Process the ResultSet object
            while (rs.next()) {
                //Get Student Details
                String name = (rs.getString(2) + " " + rs.getString(3));
                String gender = rs.getString(4);
                Date dob = Date.valueOf(rs.getString(5));
                String nic = rs.getString(6);
                String address = rs.getString(7);
                int phone = Integer.parseInt(rs.getString(8));
                String email = rs.getString(9);
                Date admissionDate = Date.valueOf(rs.getString(10));
                String batch = rs.getString(11);
                String status = rs.getString(12);

                //SQL QUERY (RETRIEVE)
                String sql2 = QueryStudent.SEE_STUDENT_SUBJECTS;
                //Create a statement using connection object
                preparedStatement = con.prepareStatement(sql2);
                //Get data and Add data to PreparedStatement
                preparedStatement.setString(1,rs.getString(2));
                preparedStatement.setString(2,rs.getString(3));

                //Execute the query
                ResultSet rs2 = preparedStatement.executeQuery();

                //Declare and assign value
                String tempsubject="";

                //Process the ResultSet object
                while(rs2.next()){
                    //Get Subjects
                    tempsubject = tempsubject+ rs2.getString(3)+" ";
                }

                //Create an Object
                student = new Student();

                //Retrieve Student Details from studentdetails table(DB) & studentlearnsubject table(DB)
                student.setId(id);
                student.setFirstName(name);
                student.setGender(gender);
                student.setDob(dob);
                student.setNic(nic);
                student.setAddress(address);
                student.setPhone(phone);
                student.setEmail(email);
                student.setAdmissionDate(admissionDate);
                student.setBatch(batch);
                student.setList(tempsubject);
                student.setStatus(status);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    //Generate Student List Report
    public   void generatePDF() throws IOException, DocumentException {
        //Create an Object
        StudentService studentService = new StudentService();
        //Call Service Method
        ArrayList<Student> list = new ArrayList<>();
        //Call viewAttendMarkers function in attendanceMarkerService
        list =studentService.ViewStudent();

        //Create an Object
        Document document = new Document();

        //Define Output File Path
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\ADMIN\\reports\\studentList" + ".pdf"));
        document.open();

        //Heading Designs
        com.itextpdf.text.Font heading1 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 13, com.itextpdf.text.Font.BOLD, BaseColor.BLUE);
        com.itextpdf.text.Font heading2 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, com.itextpdf.text.Font.NORMAL, BaseColor.BLUE);
        com.itextpdf.text.Font heading3 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, com.itextpdf.text.Font.BOLD, BaseColor.WHITE);

        //Declare a variable and assign a value
        int count =1;

        //Define Header Titles
        Chunk head = new Chunk("ARIEAEDU", heading1);
        Chunk head3 = new Chunk("Student list", heading1);
        Chunk head2 = new Chunk("\n54/3 New Kandy Road ,Kotalawela,Malabe\nHotline:072323435\nemail:Rasa@gmail.com", heading2);

        //Image Path (PDF Logo)
        String path = "C:\\Users\\ADMIN\\reports\\logo.png";
        com.itextpdf.text.Image img = Image.getInstance(path);

        PdfPTable table1 = new PdfPTable(2); // 3 columns.
        PdfPTable table2 = new PdfPTable(1); // 1 column

        //Create an Object
        Paragraph p1 = new Paragraph();
        //Print Heads
        p1.add(head);
        p1.add(head2);

        //Create Header Cell Objects
        PdfPCell cella = new PdfPCell(img);
        PdfPCell cellb = new PdfPCell(p1);
        PdfPCell cellc = new PdfPCell(new Paragraph(head3));

        //Decorations for PDF Header
        //Set Border Widths
        cella.setBorderWidth(0);
        cellb.setBorderWidth(0);
        cellc.setBorderWidth(0);
        //Set Height
        cella.setFixedHeight(100);
        //Set Background Colour For Header
        cellc.setBackgroundColor(BaseColor.WHITE);
        //Set Header Table Width Percentages
        table1.setWidthPercentage(100);
        table2.setWidthPercentage(200);

        table1.addCell(cella);
        table1.addCell(cellb);
        table2.addCell(cellc);
        document.add(table2);
        document.add(table1);
        document.add(table2);

        //Define Current Date
        LocalDate date = LocalDate.now();
        //Print Today's Date
        Paragraph main = new Paragraph("Date  " + date);
        main.setSpacingAfter(40);
        document.add(main);

        float[] columnWidths = {200, 200, 200, 200};
        PdfPTable table = new PdfPTable(columnWidths); // 4 columns.

        //Table Header Names
        PdfPCell cell1 = new PdfPCell(new Phrase("Student ID", heading3));
        PdfPCell cell2 = new PdfPCell(new Phrase("Full Name", heading3));
        PdfPCell cell3 = new PdfPCell(new Phrase("Batch", heading3));
        PdfPCell cell4 = new PdfPCell(new Phrase("Status", heading3));

        //Set Cell BackgroundColor
        cell1.setBackgroundColor(BaseColor.BLUE);
        cell2.setBackgroundColor(BaseColor.BLUE);
        cell3.setBackgroundColor(BaseColor.BLUE);
        cell4.setBackgroundColor(BaseColor.BLUE);

        //Add Table Header Names to Cell
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);

        for(Student st: list) {
            //Table Data
            PdfPCell cell5 = new PdfPCell(new Phrase(st.getId()+" "));
            PdfPCell cell6= new PdfPCell(new Phrase(st.getFullName()));
            PdfPCell cell7 = new PdfPCell(new Phrase(st.getBatch()));
            PdfPCell cell8 = new PdfPCell(new Phrase(st.getStatus()));

            //Add Data to Cell
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);
        }
        document.add(table);
        document.close();
    }
}