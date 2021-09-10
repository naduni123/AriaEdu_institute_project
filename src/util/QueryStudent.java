package util;

public class QueryStudent {

    //Queries
    public static final String ADD_STUDENT = "INSERT INTO studentdetails(firstName, lastName, gender, dob, nic, address, phone, email, admissionDate, batch) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String ADD_STUDENT_SUBJECT ="INSERT INTO studentlearnsubject(firstName,lastName, subject) values(?, ?, ?)";
    public static final String SEE_ALL_STUDENT = "SELECT * FROM studentdetails";
    public static final String SEE_STUDENT_BY_STUDENTID = "SELECT * FROM studentdetails WHERE id = ?";
    public static final String SEE_STUDENT_SUBJECTS          =  "SELECT * FROM studentlearnsubject WHERE firstName=? AND +lastName=?";

}
