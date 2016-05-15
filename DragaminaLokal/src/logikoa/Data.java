package logikoa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Data {
	
	Connection conn;
	Statement st;
	ResultSet res;


	public Data(){
		//Load MySQL driver
		
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Open connection
		
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dragamina", 
					"root", "euiti");
			st = conn.createStatement();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String sentence){
		try{
			st= conn.createStatement();
			this.res=st.executeQuery(sentence);
			return res;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public void executeUpdate(String sentence){
		try{
			st= conn.createStatement();
			st.executeUpdate(sentence);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
