package JDBCPrograms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Transaction {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String dbURL = "jdbc:mysql://localhost:3306/animated_movies";
		String username = "root";
		String password = "root";
		String query1 = "update movies set release_year='2003' where title='movie1'" ;
		String query2 = "update movies set release_year='2001' where title='Toy Story 4'";
		String query3 = "update movies set release_year='2015' where title = 'Inside Out'";
		boolean flag = false;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(dbURL, username, password);
		
		con.setAutoCommit(false);
		Statement stmt = con.createStatement();
		stmt.addBatch(query1);
		stmt.addBatch(query2);
		stmt.addBatch(query3);
		
	int [] result =	stmt.executeBatch();

	
	for(int i=0; i<result.length;i++)
	{
		System.out.println(result[i]);
		if(result[i] == 0) 
		{
			flag = true;
			break;
		}
		
	}
		
	if(flag == false) {
		
		con.commit();
		System.out.println("transaction Complete");
	}
	else {
		
		con.rollback();	
		System.out.println("transaction Failure");
	}
		

	}

	

}
