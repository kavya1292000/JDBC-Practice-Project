package JDBCPrograms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class P2InsertData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String dbURL = "jdbc:mysql://localhost:3306/animated_movies";
		String username = "root";
		String password = "root";
		String title = "Finding Nemo";
		String genre = "comedy";
		String director = "Andrew";
		String release_year = "2003";
		
		Connection con = DriverManager.getConnection(dbURL, username, password);
		
	    PreparedStatement ps = con.prepareStatement("insert into movies values (?,?,?,?)"); 
		
	    ps.setString(1, title);
	    
	    ps.setString(2, genre);
	    
	    ps.setString(3, director);
	    
	    ps.setString(4, release_year);
	    
	    ps.executeUpdate();
	    
	    con.close();
		

	}

}

