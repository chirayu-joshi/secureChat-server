package com.secureChat.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.secureChat.connectDB.Connect;
import com.secureChat.model.Chat;
import com.secureChat.model.ResponseMessage;

public class ChatService {

	public List<Chat> getChats(long senderId, long receiverId) {

		final String fetchChatsQuery = "SELECT * FROM chats WHERE sender_id=" + senderId + " AND receiver_id="
				+ receiverId + " AND sender_id != receiver_id";
		List<Chat> chats = new ArrayList<Chat>();

		try {

			Connect connect = new Connect("jdbc:mysql://localhost:3306/secure_chat", "root", "abcd1234");
			Connection con = connect.establishDBConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(fetchChatsQuery);

			while (rs.next()) {
				chats.add(new Chat(rs.getLong("id"), rs.getLong("sender_id"), rs.getLong("receiver_id"),
						rs.getString("message")));
			}

			st.close();
			connect.closeDBConnection();

			return chats;

		} catch (Exception e) {
			return chats;
		}

	}

	public ResponseMessage saveChat(long senderId, long receiverId, String message) {

		final String saveChatQuery = "INSERT INTO chats (`sender_id`, `receiver_id`, `message`) VALUES (" + senderId
				+ ", " + receiverId + ", '" + message + "')";

		try {

			Connect connect = new Connect("jdbc:mysql://localhost:3306/secure_chat", "root", "abcd1234");
			Connection con = connect.establishDBConnection();
			Statement st = con.createStatement();
			int result = st.executeUpdate(saveChatQuery);

			if (result == 1) {
				st.close();
				connect.closeDBConnection();
				return new ResponseMessage("Chat saved successfully", 200);
			} else {
				st.close();
				connect.closeDBConnection();
				return new ResponseMessage("Chat couldn't be saved", 400);
			}

		} catch (Exception e) {
			return new ResponseMessage("Chat couldn't be saved", 500);
		}
		
	}

}
