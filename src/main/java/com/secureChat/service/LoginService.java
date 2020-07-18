package com.secureChat.service;

import java.sql.*;

import com.secureChat.connectDB.Connect;
import com.secureChat.model.Login;

public class LoginService {

	public Login checkAuth(String email, String password) {
		
		final String checkAuthQuery = "SELECT * FROM users WHERE email='" + email + "' AND passwd='" + password + "'";
		
		try {
			
			Connect connect = new Connect("jdbc:mysql://localhost:3306/secure_chat", "root", "abcd1234");
			Connection con = connect.establishDBConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(checkAuthQuery);
			
			if (rs.next()) {
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				long uid = rs.getLong("uid");
				
				st.close();
				connect.closeDBConnection();
				return new Login(true, firstname, lastname, uid);
			} else {
				st.close();
				connect.closeDBConnection();
				return new Login(false, "", "", -1);
			}
			
		} catch (Exception e) {
			return new Login(false, "", "", -1);
		}

	}

}
