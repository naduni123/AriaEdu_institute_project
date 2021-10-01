package service;

//imports
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.Classroom;
import util.DBConnectionUtil;
import util.QueryTimeAndClass;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;



public class ClassroomService implements IClassroom {

    Connection con;
    PreparedStatement preparedStatement;


    //ADD CLASSROOM
    @Override
    public void addClassroom(Classroom classroom) {

        try {
            con = DBConnectionUtil.getConnection();
            String sql = QueryTimeAndClass.ADD_CLASS;
            preparedStatement = con.prepareStatement(sql);



            preparedStatement.setString(1,classroom.getName());
            preparedStatement.setString(2,classroom.getFloor());
            preparedStatement.setInt(3,classroom.getCapacity());
            preparedStatement.setString(4,classroom.getAc());




            preparedStatement.execute();

        }catch(Exception e){

            e.printStackTrace();
        }

    }

    //EDIT CLASSROOM
    @Override
    public void editClassroom(Classroom classroom) {
        try {
            con = DBConnectionUtil.getConnection();
            String sql = QueryTimeAndClass.UPDATE_CLASS+classroom.getId();
            preparedStatement = con.prepareStatement(sql);



            preparedStatement.setString(1,classroom.getName());
            preparedStatement.setString(2,classroom.getFloor());
            preparedStatement.setInt(3,classroom.getCapacity());
            preparedStatement.setString(4,classroom.getAc());



            preparedStatement.execute();

        }catch(Exception e){

            e.printStackTrace();
        }
    }

    //VIEW CLASSROOM
    @Override
    public ArrayList<Classroom> viewClassroom() {

        ArrayList<Classroom> list = new ArrayList<>();

        try {

            con = DBConnectionUtil.getConnection();
            String sql=QueryTimeAndClass.SEE_CLASS;

            preparedStatement = con.prepareStatement(sql);


            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                int id =Integer.parseInt(rs.getString(1));
                String name= (rs.getString(2));
                String floor =rs.getString(3);
                int capacity =Integer.parseInt(rs.getString(4));
                String ac =rs.getString(5);


                Classroom classroom = new Classroom();

                classroom.setId(id);
                classroom.setName(name);
                classroom.setFloor(floor);
                classroom.setCapacity(capacity);
                classroom.setAc(ac);


                list.add(classroom);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;



    }

    //DELETE CLASSROOM
    @Override
    public boolean deleteClassroom(int id) {
        boolean rowdeleted = false;
        try {

            con = DBConnectionUtil.getConnection();
            String sql=QueryTimeAndClass.DELETE_CLASS+id;

            preparedStatement = con.prepareStatement(sql);


             rowdeleted = preparedStatement.executeUpdate() >0;




        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
            return rowdeleted;
    }


    //SEARCH
    public Classroom findClassroom(int id){

        Classroom classroom =  new Classroom();

        try {

            con = DBConnectionUtil.getConnection();
            String sql=QueryTimeAndClass.FIND_CLASS+id;

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {

                classroom.setId(rs.getInt(1));
                classroom.setName(rs.getString(2));
                classroom.setFloor(rs.getString(3));
                classroom.setCapacity(rs.getInt(4));
                classroom.setAc(rs.getString(5));


                System.out.println("service" + classroom.getAc());

            } 


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return classroom;


    }

    //REPORT GENERATION
    public void generatepdf() throws IOException, DocumentException {

        ArrayList<Classroom> list = viewClassroom();
        //LocalDate date = LocalDate.now();
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Kavindu Balasooriya\\Desktop\\report\\classlist" + ".pdf"));
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
        PdfPCell cell1 = new PdfPCell(new Paragraph("Name"));
        PdfPCell cell2 = new PdfPCell(new Paragraph("Floor"));
        PdfPCell cell3 = new PdfPCell(new Paragraph("Capacity"));
        PdfPCell cell4 = new PdfPCell(new Paragraph("Feature"));

        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);

        for(Classroom at: list) {

            PdfPCell cell5 = new PdfPCell(new Paragraph(at.getName()));
            PdfPCell cell6= new PdfPCell(new Paragraph(at.getFloor()));
            PdfPCell cell7 = new PdfPCell(new Paragraph(at.getCapacity()));
            PdfPCell cell8 = new PdfPCell(new Paragraph(at.getAc()));



            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);




        }

        document.add(table);
        document.close();
    }


}
