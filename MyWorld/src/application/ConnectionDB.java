package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
<<<<<<< HEAD
	/*Connection conn = null;
    public static Connection connect()
=======
	Connection conn = null;

	public static Connection connect()
>>>>>>> ecbc26eb4f33629da25b01e72991ab0e337ccc24
    {
        try {
        	//@MICHAELLA
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/keeptoo_systems", "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("ConnectionUtil : "+ex.getMessage());
           return null;
        }
    }
    
}
