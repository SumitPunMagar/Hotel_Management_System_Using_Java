package hotel_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {

    public Connection c;
    public Statement s;

    // constructor
    public Conn(){

        try {

            // create connection
            c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","admin@123");

            // create statement
            s = c.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
