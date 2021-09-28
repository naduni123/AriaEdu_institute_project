package util;

public class QueryTimeAndClass {

    public static final String ADD_CLASS = "INSERT INTO classroom(name,floor,capacity,ac) values(?,?,?,?)";
    public static final String UPDATE_CLASS = "update classroom set name =? , floor =? ,capacity=? , ac = ? where id =  ";
    public static final String SEE_CLASS="SELECT * FROM classroom";


    public static final String ADD_TIMESLOT = "INSERT INTO timeslot(batch,day,starttime,endtime,subject,teacher,classroom) values(?,?,?,?,?,?,?)";
    public static final String EDIT_TIMESLOT = "UPDATE timeslot SET batch = ?,day =? ,starttime =?,endtime =? ,subject =? ,teacher =? ,classroom =?  where id =";
    public static final String SEE_TIME="SELECT * FROM timeslot";
    public static final String FIND_TIME ="SELECT * FROM timeslot WHERE id = ";
    public static final String SEE_TIME_TEACHER="SELECT * FROM timeslot WHERE teacher= ";
    public static final String SEE_TIME_BATCH="SELECT * FROM timeslot WHERE batch= ";
    public static final String SEE_TIME_EXTEND="SELECT t.id , t.subject , t.day ,t.starttime , t.endtime , b.name , te.full_name , c.name from classroom c,teacher te,timetable t where t.teacher = te.id and t.batch = b.id and t.classroom =c.id  ";
    public static final String DELETE_TIME="delete from timeslot WHERE id = ";

    public static final String SEE_BATCH= "SELECT * FROM batch";
    public static final String FIND_TEACHER="SELECT * FROM teacher WHERE id = ";
    public static final String SEE_TEACHERS="SELECT * FROM teacher";
    public static final String FIND_CLASS="SELECT * FROM classroom WHERE id = ";
    public static final String FIND_BATCH="SELECT * FROM batch WHERE id = ";

}
