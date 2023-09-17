package UnsolveCases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {

	public static void main(String[] args) {
//		
		try {

			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			Connection conn = DriverManager
					.getConnection("jdbc:sqlserver://DESKTOP-9B3BV7M\\SQLEXPRESS;database=MyData;");
			System.out.println("connection created");
			Statement st = conn.createStatement();
			String sql = "select * from dbo.Assets";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println("Name: " + rs.getString(1));

			}
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (SQLException sqle) {
			System.out.println("Sql exception " + sqle);
		}
	}
}
