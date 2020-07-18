package com.secureChat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.secureChat.model.Chat;
import com.secureChat.model.ChatPayload;
import com.secureChat.model.ResponseMessage;
import com.secureChat.service.ChatService;
import com.secureChat.util.PostRequest;

public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChatService service = new ChatService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Chat> chats = new ArrayList<>();
		chats = service.getChats(Long.parseLong(request.getParameter("senderId")), Long.parseLong(request.getParameter("receiverId")));
		
		Gson gson = new Gson();
		String chatJSON = gson.toJson(chats);
		
		PrintWriter printWriter = response.getWriter();
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		printWriter.write(chatJSON);
		printWriter.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson gson = new Gson();
		
		String payload = PostRequest.getBody(request);
		ChatPayload chatPayload = gson.fromJson(payload, ChatPayload.class);
		
		ResponseMessage responseMessage = service.saveChat(chatPayload.getSenderId(), chatPayload.getReceiverId(), chatPayload.getMessage());
		String responseMessageJSON = gson.toJson(responseMessage);
		
		PrintWriter printWriter = response.getWriter();
		PostRequest.addHeaders(response);
		printWriter.write(responseMessageJSON);
		printWriter.close();
		
	}

	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		response.setStatus(HttpServletResponse.SC_OK);
	}
	
	private void setAccessControlHeaders(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
	}

}
