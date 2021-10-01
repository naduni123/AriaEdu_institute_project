package service;

//imports
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.Classroom;
import model.TimeSlot;
import util.DBConnectionUtil;
import util.QueryTimeAndClass;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TimeSlotService implements ITimeSlot {

    Connection con;
    PreparedStatement preparedStatement;

    //ADD TIMESLOT
    @Override
    public void AddTimeSlot(TimeSlot timeSlot) {

        try {
            con = DBConnectionUtil.getConnection();
            String sql = QueryTimeAndClass.ADD_TIMESLOT;
            preparedStatement = con.prepareStatement(sql);


            preparedStatement.setInt(1,timeSlot.getBatch());
            preparedStatement.setString(2,timeSlot.getDate());
            preparedStatement.setString(3,timeSlot.getStartTime());
            preparedStatement.setString(4,timeSlot.getEndTime());
            preparedStatement.setString(5,timeSlot.getSubject());
            preparedStatement.setInt(6,timeSlot.getTeacher());
            preparedStatement.setInt(7,timeSlot.getClassroom());




            preparedStatement.execute();

        }catch(Exception e){

            e.printStackTrace();
        }

    }

    //VIEW TIMESLOT
    @Override
    public ArrayList<TimeSlot> viewTime() {
        ArrayList<TimeSlot> list = new ArrayList<>();

        try {

            con = DBConnectionUtil.getConnection();
            String sql=QueryTimeAndClass.SEE_TIME;

            preparedStatement = con.prepareStatement(sql);


            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                TimeSlot timeSlot = new TimeSlot();

                timeSlot.setSubject(rs.getString(6));
                timeSlot.setDate(rs.getString(3));
                timeSlot.setStartTime(rs.getString(4));
                timeSlot.setEndTime(rs.getString(5));
                timeSlot.setClassroom(rs.getInt(8));
                timeSlot.setBatch(rs.getInt(2));


                list.add(timeSlot);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //DELETE TIMESLOT
    @Override
    public boolean deleteTime(int id) {
        boolean rowdeleted = false;
        try {

            con = DBConnectionUtil.getConnection();
            String sql=QueryTimeAndClass.DELETE_TIME+id;

            preparedStatement = con.prepareStatement(sql);


            rowdeleted = preparedStatement.executeUpdate() >0;




        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rowdeleted;
    }


    //UPDATE TIMESLOT
    @Override
    public boolean UpdateTimeSlot(TimeSlot timeSlot) {
        boolean rowupdated = false;
        try {
            con = DBConnectionUtil.getConnection();
            String sql = QueryTimeAndClass.EDIT_TIMESLOT+timeSlot.getId();
            preparedStatement = con.prepareStatement(sql);
            System.out.println(sql);

            preparedStatement.setInt(1,timeSlot.getBatch());
            preparedStatement.setString(2,timeSlot.getDate());
            preparedStatement.setString(3,timeSlot.getStartTime());
            preparedStatement.setString(4,timeSlot.getEndTime());
            preparedStatement.setString(5,timeSlot.getSubject());
            preparedStatement.setInt(6,timeSlot.getTeacher());
            preparedStatement.setInt(7,timeSlot.getClassroom());




            System.out.println(sql);

            rowupdated =preparedStatement.executeUpdate(  )>0;

        }catch(Exception e){

            e.printStackTrace();
        }

        return rowupdated;
    }

    //VIEW TIME BY TEACHER ID
    public ArrayList<TimeSlot> viewTimeByTeacherID(int id) {
        ArrayList<TimeSlot> list = new ArrayList<>();
        System.out.println("in");

        try {

            con = DBConnectionUtil.getConnection();
            String sql=QueryTimeAndClass.SEE_TIME_TEACHER+id;

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                TimeSlot timeSlot = new TimeSlot();

                timeSlot.setSubject(rs.getString(6));
                timeSlot.setDate(rs.getString(3));
                timeSlot.setStartTime(rs.getString(4));
                timeSlot.setEndTime(rs.getString(5));
                timeSlot.setClassroom(rs.getInt(8));
                timeSlot.setBatch(rs.getInt(2));
                timeSlot.setId(rs.getInt(1));

                System.out.println(timeSlot.getId());
                list.add(timeSlot);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //VIEW TIME BY BATCH ID
    public ArrayList<TimeSlot> viewTimeByBatchID(int id) {
        ArrayList<TimeSlot> list = new ArrayList<>();
        System.out.println("in");

        try {

            con = DBConnectionUtil.getConnection();
            String sql=QueryTimeAndClass.SEE_TIME_BATCH+id;

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                TimeSlot timeSlot = new TimeSlot();

                timeSlot.setSubject(rs.getString(6));
                timeSlot.setDate(rs.getString(3));
                timeSlot.setStartTime(rs.getString(4));
                timeSlot.setEndTime(rs.getString(5));
                timeSlot.setClassroom(rs.getInt(8));
                timeSlot.setTeacher(rs.getInt(7));
                timeSlot.setId(rs.getInt(1));

                System.out.println(timeSlot.getId());
                list.add(timeSlot);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //BACKEND VALIDATION FOR CLASSROOM USAGE
    public boolean check(String start, String end, String classroom){

        boolean check = false;

        try {

            con = DBConnectionUtil.getConnection();
            String sql="select count (id)  from timeslot where classroom ='"+classroom+"'  and id in(select id from timeslot where starttime >='"+start+"' or endtime < '"+end+"' )";

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            System.out.println(rs.getString(1));



            if(rs.getString(1) != null){
                check =true;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return check;


    }

    //TEACHER TIME TABLE REPORT
    public void teacherPdf(int id) throws IOException, DocumentException {
        ArrayList<TimeSlot> list = viewTimeByTeacherID(id);
        //LocalDate date = LocalDate.now();
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Kavindu Balasooriya\\Desktop\\report\\Teacher "+id+".pdf"));
        document.open();
        com.itextpdf.text.Font heading1 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 13, com.itextpdf.text.Font.BOLD, BaseColor.BLUE);
        com.itextpdf.text.Font heading2 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, com.itextpdf.text.Font.NORMAL, BaseColor.BLUE);
        com.itextpdf.text.Font heading3 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
        int count =1;

        Chunk head = new Chunk("ARIEAEDU", heading1);
        Chunk head3 = new Chunk("Attendance markers list", heading1);
        Chunk head2 = new Chunk("\n54/3 New Kandy Road ,Kotalawela,Malabe\nHotline:072323435\nemail:AriaEdu@gmail.com", heading2);

        //image path
        String path = "C:\\Users\\Kavindu Balasooriya\\Desktop\\report\\logo.png";
        com.itextpdf.text.Image img = Image.getInstance(path);
        PdfPTable table1 = new PdfPTable(2); // 3 columns.
        PdfPTable table2 = new PdfPTable(1); // 1 column

        Paragraph p1 = new Paragraph();
        p1.add(head);
        p1.add(head2);

        PdfPCell cella = new PdfPCell(img);
        PdfPCell cellb = new PdfPCell(p1);
        PdfPCell cellc = new PdfPCell(new Paragraph(head3));


        cella.setBorderWidth(0);
        cellb.setBorderWidth(0);
        cellc.setBorderWidth(0);
        cella.setFixedHeight(100);
        cellc.setBackgroundColor(BaseColor.WHITE);
        table1.setWidthPercentage(100);
        table2.setWidthPercentage(200);

        table1.addCell(cella);
        table1.addCell(cellb);
        table2.addCell(cellc);
        document.add(table2);
        document.add(table1);
        document.add(table2);


        LocalDate date = LocalDate.now();
        Paragraph main = new Paragraph("Date  " + date);
        main.setSpacingAfter(40);
        document.add(main);

        PdfPTable table = new PdfPTable(4); // 4 columns.
        PdfPCell cell1 = new PdfPCell(new Paragraph("Start time"));
        PdfPCell cell2 = new PdfPCell(new Paragraph("End Time"));
        PdfPCell cell3 = new PdfPCell(new Paragraph("Classroom"));
        PdfPCell cell4 = new PdfPCell(new Paragraph("Batch"));

        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);

        for(TimeSlot at: list) {

            PdfPCell cell5 = new PdfPCell(new Paragraph(at.getStartTime()));
            PdfPCell cell6= new PdfPCell(new Paragraph(at.getEndTime()));
            PdfPCell cell7 = new PdfPCell(new Paragraph(at.getClassroom()));
            System.out.println(at.getClassroom());
            PdfPCell cell8 = new PdfPCell(new Paragraph(at.getBatch()));



            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);




        }

        document.add(table);
        document.close();

    }

    //STUDENT TIME TABLE REPORT
    public void studentPdf(int id) throws IOException, DocumentException {
        ArrayList<TimeSlot> list = viewTimeByTeacherID(id);
        //LocalDate date = LocalDate.now();
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Kavindu Balasooriya\\Desktop\\report\\Student "+id+".pdf"));
        document.open();
        com.itextpdf.text.Font heading1 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 13, com.itextpdf.text.Font.BOLD, BaseColor.BLUE);
        com.itextpdf.text.Font heading2 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, com.itextpdf.text.Font.NORMAL, BaseColor.BLUE);
        com.itextpdf.text.Font heading3 = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
        int count =1;

        Chunk head = new Chunk("ARIEAEDU", heading1);
        Chunk head3 = new Chunk("Attendance markers list", heading1);
        Chunk head2 = new Chunk("\n54/3 New Kandy Road ,Kotalawela,Malabe\nHotline:072323435\nemail:AriaEdu@gmail.com", heading2);

        //image path
        String path = "C:\\Users\\Kavindu Balasooriya\\Desktop\\report\\logo.png";
        com.itextpdf.text.Image img = Image.getInstance(path);
        PdfPTable table1 = new PdfPTable(2); // 3 columns.
        PdfPTable table2 = new PdfPTable(1); // 1 column

        Paragraph p1 = new Paragraph();
        p1.add(head);
        p1.add(head2);

        PdfPCell cella = new PdfPCell(img);
        PdfPCell cellb = new PdfPCell(p1);
        PdfPCell cellc = new PdfPCell(new Paragraph(head3));


        cella.setBorderWidth(0);
        cellb.setBorderWidth(0);
        cellc.setBorderWidth(0);
        cella.setFixedHeight(100);
        cellc.setBackgroundColor(BaseColor.WHITE);
        table1.setWidthPercentage(100);
        table2.setWidthPercentage(200);

        table1.addCell(cella);
        table1.addCell(cellb);
        table2.addCell(cellc);
        document.add(table2);
        document.add(table1);
        document.add(table2);


        LocalDate date = LocalDate.now();
        Paragraph main = new Paragraph("Date  " + date);
        main.setSpacingAfter(40);
        document.add(main);

        PdfPTable table = new PdfPTable(4); // 4 columns.
        PdfPCell cell1 = new PdfPCell(new Paragraph("Start time"));
        PdfPCell cell2 = new PdfPCell(new Paragraph("End Time"));
        PdfPCell cell3 = new PdfPCell(new Paragraph("Subject"));
        PdfPCell cell4 = new PdfPCell(new Paragraph("Teacher"));

        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);

        for(TimeSlot at: list) {

            PdfPCell cell5 = new PdfPCell(new Paragraph(at.getStartTime()));
            PdfPCell cell6= new PdfPCell(new Paragraph(at.getEndTime()));
            PdfPCell cell7 = new PdfPCell(new Paragraph(at.getSubject()));
            System.out.println(at.getClassroom());
            PdfPCell cell8 = new PdfPCell(new Paragraph(at.getTeacher()));



            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);




        }

        document.add(table);
        document.close();

    }
}
