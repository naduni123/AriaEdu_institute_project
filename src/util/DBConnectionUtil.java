package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectionUtil {
    private static Connection conn;

    private DBConnectionUtil() {
    }

    /**
     * CREATE DATABASE CONNECTION
     *
     * @return SQL CONNECTION FOR MICROSOFT SQL SERVER DATABASE
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public static Connection getConnection() throws ClassNotFoundException, SQLException{

        /*
         * CREATE NEW CONNECTION WHEN CONNECTION IS CLOSED OR NULL
         */
        try {
            if( conn == null || conn.isClosed() )
            {

                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ariaedu?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                        "root",
                        "");


            }
        }
        catch (ClassNotFoundException  e) {

            e.printStackTrace();
        }


        return conn;
    }

    public static void closeConnection(PreparedStatement preparedStatement , Connection conn) {
        try {
            if(preparedStatement != null) {
                preparedStatement.close();
            }
            if(conn != null) {
                conn.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
