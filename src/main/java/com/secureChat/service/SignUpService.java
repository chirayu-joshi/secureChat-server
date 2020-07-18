package com.secureChat.service;

import java.sql.Connection;
import java.sql.Statement;

import com.secureChat.connectDB.Connect;
import com.secureChat.model.SignUp;

public class SignUpService {
	
	public SignUp createUser(String firstname, String lastname, String email, String password) {
		
		final String createUserQuery = "INSERT INTO users (`firstname`, `lastname`, `email`, `passwd`) VALUES ('" + firstname + "', '" + lastname + "', '" + email + "', '" + password + "')";
		
		try {
			
			Connect connect = new Connect("jdbc:mysql://localhost:3306/secure_chat", "root", "abcd1234");
			Connection con = connect.establishDBConnection();
			Statement st = con.createStatement();
			int result = st.executeUpdate(createUserQuery);
			
			if (result == 1) {
				st.close();
				connect.closeDBConnection();
				return new SignUp(true, firstname, lastname, email, password);
			} else {
				st.close();
				connect.closeDBConnection();
				return new SignUp(false, "", "", "", "");
			}
			
		} catch(Exception e) {
			return new SignUp(false, "", "", "", "");
		}
		
	}

}
