
/*
	* (C) copyright 2018 Fresher Academy.
	* 
	* @author hoangcode
	* @date Apr 7, 2018
	* @version 1.0
*/

package fa.hoangtq3.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection createConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/busticket";
		String username = "root";
		String password = "";

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Post establishing a DB connection - " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
}
