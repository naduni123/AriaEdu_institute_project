package util;

public class QueryTimeAndClass {

    public static final String ADD_CLASS = "INSERT INTO classroom(name,floor,capacity,ac) values(?,?,?,?)";
    public static final String UPDATE_CLASS = "update classroom(name,floor,capacity,ac) values(?,?,?,?) ";
    public static final String SEE_CLASS="SELECT * FROM classroom";



}