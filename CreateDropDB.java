package JDBCPrograms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDropDB {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String dbURL = "jdbc:mysql://localhost:3306/animated_movies";
		String username = "root";
		String password = "root";
		String query1 = "create database products" ;
		String query2 = "use products";
		String query3 = "drop database products" ;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(dbURL, username, password);

		Statement stmt = con.createStatement();
		
		stmt.executeUpdate(query1);
		
		System.out.println("Database created successfully");
		
		stmt.executeUpdate(query2);
		
		System.out.println("Database selected successfully");
		
		stmt.executeUpdate(query3);
		
		System.out.println("Database dropped successfully");
		
		con.close();
				
		

	}


}
