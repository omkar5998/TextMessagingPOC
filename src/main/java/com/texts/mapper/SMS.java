package com.texts.mapper;

import java.io.Serializable;

public class SMS implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String sendTo;

	private String message;

	public SMS(String sendTo, String message) {
		super();
		this.sendTo = sendTo;
		this.message = message;
	}
	

	public SMS() {
		super();
	}


	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SMS [sendTo=" + sendTo + ", message=" + message + "]";
	}

}
