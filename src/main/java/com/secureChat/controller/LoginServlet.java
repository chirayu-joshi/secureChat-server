package com.secureChat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.secureChat.model.Login;
import com.secureChat.model.LoginPayload;
import com.secureChat.service.LoginService;
import com.secureChat.util.PostRequest;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService service = new LoginService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson gson = new Gson();
		
		String payload = PostRequest.getBody(request);
		LoginPayload loginPayload = gson.fromJson(payload, LoginPayload.class);
				
		Login isAuthenticated = service.checkAuth(loginPayload.getEmail(), loginPayload.getPassword());
		String loginJSON = gson.toJson(isAuthenticated);
		
		PrintWriter printWriter = response.getWriter();
		PostRequest.addHeaders(response);
		printWriter.write(loginJSON);
		printWriter.close();
		
	}
	
	// For preflight
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
