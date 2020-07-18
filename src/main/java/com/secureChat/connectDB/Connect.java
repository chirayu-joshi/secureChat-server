package com.secureChat.connectDB;

import java.sql.*;

public class Connect {

	final String databaseUrl;
	final String databaseUser;
	final String databasePassword;
	Connection con;
	
	public Connect(String databaseUrl, String databaseUser, String databasePassword) throws Exception {
		super();
		
		Class.forName("com.mysql.jdbc.Driver");
		
		this.databaseUrl = databaseUrl;
		this.databaseUser = databaseUser;
		this.databasePassword = databasePassword;
	}
	
	public Connection establishDBConnection() throws Exception {
		con = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
		return con;
	}
	
	public void closeDBConnection() throws Exception {
		con.close();
	}
	
}
