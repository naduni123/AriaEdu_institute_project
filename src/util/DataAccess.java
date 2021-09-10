package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataAccess {

    private static Connection con;

    public static Connection connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");//get java file

            if (con == null) {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/modee?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
                System.out.println(con);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql");
            e.printStackTrace();
        }

        return con;
    }
}
