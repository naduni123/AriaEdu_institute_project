package util;

public class QueryAttendance {

    public static final String ADD_ATTENDANCE_MARKER ="INSERT INTO attendancemarker(fname,lname,dob,nic,address,gender,phone,email,teacher) values(?,?,?,?,?,?,?,?,?)";
    public static final String ADD_ATTEND_SUBJECT ="INSERT INTO attendsubject(attid,fname,lname,subject) values(?,?,?,?)";
    public static final String SEE_ATTEND_MARKERS ="SELECT * FROM attendancemarker";
    public static final String DELETE_ATT_MARKER ="DELETE FROM attendancemarker where id = ";
    public static final String SEE_STUDENT="select * from studentdetails where id not in (select sid from attendance where date=CURDATE())";
    public static final String FIND_STUDENT="SELECT * FROM studentdetails where";
    public static final String ADD_ATT ="INSERT INTO attendance(sid,date,status,subject,batch) values(?,?,?,?,?) ";
    public static final String SEE_ATT="select  * from studentdetails where id in(select sid from attendance where date=CURDATE())";
    public static final String FIND_ATT_MARKER = " select * from attendancemarker where id =";
    public static final String UPDATE_ATT_MARKER ="update attendancemarker set fname=?,lname=?,address=?,phone=?,email=?,teacher=? where id=";
}
