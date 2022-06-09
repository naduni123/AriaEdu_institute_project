package util;

public class QueryStudent {

    public static final String ADD_STUDENT = "INSERT INTO studentdetails(firstName, lastName, gender, dob, nic, address, phone, email, admissionDate, batch) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String ADD_STUDENT_SUBJECT ="INSERT INTO studentlearnsubject(firstName,lastName, subject) values(?, ?, ?)";
    public static final String SEE_ALL_STUDENT = "SELECT * FROM studentdetails";
    public static final String SEE_STUDENT_BY_STUDENTID = "SELECT * FROM studentdetails WHERE id = ?";
    public static final String SEE_STUDENT_SUBJECTS = "SELECT * FROM studentlearnsubject WHERE firstName=? AND +lastName=?";
    public static final String UPDATE_STUDENT_DETAILS = "UPDATE studentdetails SET address=?, phone=?, email=?, status=? WHERE id = ";
    public static final String UPDATE_STUDENT_SUBJECT = "UPDATE studentlearnsubject SET subject=? WHERE id = ?";
    public static final String SEE_STUDENTS_BY_BATCH = "SELECT * FROM studentdetails WHERE batch = ?";
    public static final String SEE_STUDENTS_BY_STATUS = "SELECT * FROM studentdetails WHERE status = ?";
    public static final String DELETE_STUDENT ="DELETE FROM studentdetails where id = ?";
    public static final String DELETE_SUBJECT ="DELETE FROM studentlearnsubject where firstName=? AND lastName=?";

}
