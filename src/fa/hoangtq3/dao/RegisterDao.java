
/*
	* (C) copyright 2018 Fresher Academy.
	* 
	* @author hoangcode
	* @date Apr 7, 2018
	* @version 1.0
*/

package fa.hoangtq3.dao;

import fa.hoangtq3.model.RegisterModel;
import fa.hoangtq3.database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

	public String registerUser(RegisterModel registerModel) {
		
		String notification= "hmm.. Something went wrong there..!";
		String fullname = registerModel.getFullName();
		String gender = registerModel.getGender();
		String email = registerModel.getEmail();
		String username = registerModel.getUserName();
		String password = registerModel.getPassword();

		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = DBConnection.createConnection();
			String query = "insert into users(idUs,fullname,gender,email,username,password) values (NULL,?,?,?,?,?)";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, fullname);
			preparedStatement.setString(2, gender);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, username);
			preparedStatement.setString(5, password);
			//
			int i = preparedStatement.executeUpdate();
			if (i != 0)
				return "SUCCESS";

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return notification;

	}

}
