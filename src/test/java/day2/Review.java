package day2;

import java.sql.*;

public class Review {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@3.88.133.239:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;

        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet rs   =   stmt.executeQuery("SELECT * FROM JOBS") ;

        //I want to read the first row
        rs.next();
        System.out.println("First column value in jobs: "+rs.getString(1));
        System.out.println("First column value in jobs: "+rs.getString(2));





    }
}
