package util;

public class QueryTimeAndClass {

    public static final String ADD_CLASS = "INSERT INTO classroom(name,floor,capacity,ac) values(?,?,?,?)";
    public static final String UPDATE_CLASS = "update classroom(name,floor,capacity,ac) values(?,?,?,?) ";
    public static final String SEE_CLASS="SELECT * FROM classroom";


    public static final String ADD_TIMESLOT = "INSERT INTO timeslot(batch,day,starttime,endtime,subject,teacher,classroom) values(?,?,?,?,?,?,?)";



    public static final String SEE_BATCH= "SELECT * FROM batch";
    public static final String FIND_TEACHER="SELECT * FROM teacher WHERE id = ";
    public static final String SEE_TEACHERS="SELECT * FROM teacher";

}
