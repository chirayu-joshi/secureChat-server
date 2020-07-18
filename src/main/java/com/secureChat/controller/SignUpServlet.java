package com.secureChat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.secureChat.model.SignUp;
import com.secureChat.model.SignUpPayload;
import com.secureChat.service.SignUpService;
import com.secureChat.util.PostRequest;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SignUpService service = new SignUpService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson gson = new Gson();
		
		String payload = PostRequest.getBody(request);
		SignUpPayload signUpPayload = gson.fromJson(payload, SignUpPayload.class);
				
		SignUp isUserCreated = service.createUser(signUpPayload.getFirstname(), signUpPayload.getLastname(), signUpPayload.getEmail(), signUpPayload.getPassword());
		String signUpJSON = gson.toJson(isUserCreated);
		
		PrintWriter printWriter = response.getWriter();
		PostRequest.addHeaders(response);
		printWriter.write(signUpJSON);
		printWriter.close();
		
	}
	
	// For preflight
	protected void doOptions(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		setAccessControlHeaders(response);
		response.setStatus(HttpServletResponse.SC_OK);
	}
	
	private void setAccessControlHeaders(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
	}

}
