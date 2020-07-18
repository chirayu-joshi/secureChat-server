package com.secureChat.model;

public class Chat {
	private long id;
	private long senderId;
	private long receiverId;
	private String message;
	
	public Chat(long id, long senderId, long receiverId, String message) {
		super();
		this.id = id;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.message = message;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSenderId() {
		return senderId;
	}

	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}

	public long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
