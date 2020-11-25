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

        //move to row number 7 and get above 2 value

        rs.absolute(7);
        System.out.println("First column value in jobs in row 7: "+rs.getString(1));
        System.out.println("First column value in jobs in row 7: "+rs.getString(2));

        rs.last();
        System.out.println("First column value in jobs in last row: "+rs.getString(1));
        System.out.println("First column value in jobs in last row: "+rs.getString(2));

        rs.previous();
        System.out.println("First column value in jobs in 2nd from last row: "+rs.getString(1));
        System.out.println("First column value in jobs in 2nd from last row: "+rs.getString(2));

        System.out.println("=============LOOP FROM TOP TO BUTTON PRINT JOB_ID===========");

        rs.beforeFirst();

        while(rs.next()){
            System.out.println("Loop First Column "+rs.getString("JOB_ID"));
        }

        System.out.println("=LOOP FROM LAST ROW TILL FIRST ROW GET MIN_SLARY COLUMNS AS NUMBER TO =");

        //We are currently at after last location
        //if you really want to make sure and explicitly say so
        //we can do below
        rs.afterLast();
        while(rs.previous()){
            System.out.println(" Min SALARY COLUMN AS NUMBER $"+rs.getDouble("MIN_SALARY"));
        }

        //clean up the connection, statement and resultset object after usage
        rs.close();
        stmt.close();
        conn.close();





    }
}
