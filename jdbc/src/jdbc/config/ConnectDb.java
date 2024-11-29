package jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectDb 
{
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(1);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root"); 
			System.out.println(2);
			PreparedStatement pstmt = con.prepareStatement("select * from employees");
			System.out.println(3);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString("first_name"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
