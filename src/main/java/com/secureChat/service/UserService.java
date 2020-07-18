package com.secureChat.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.secureChat.connectDB.Connect;
import com.secureChat.model.User;

public class UserService {

	public List<User> getUsers() {
		
		final String fetchUsersQuery = "SELECT * FROM users";
		List<User> users = new ArrayList<User>();
		
		try {
			
			Connect connect = new Connect("jdbc:mysql://localhost:3306/secure_chat", "root", "abcd1234");
			Connection con = connect.establishDBConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(fetchUsersQuery);
			
			while (rs.next()) {
				users.add(new User(rs.getLong("uid"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email")));
			}
			
			st.close();
			connect.closeDBConnection();
			
			return users;
			
		} catch (Exception e) {
			return users;
		}
		
	}	

}
