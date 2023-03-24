package com.qrmaster.api.exceptions;

import com.qrmaster.api.exceptions.data.ExceptionCode;

public class ServerException extends RuntimeException {

	private final ExceptionCode	exceptionCode;
	
	public ServerException(String message, ExceptionCode exceptionCode) {
		
		super(message);
		this.exceptionCode	=	exceptionCode;
	}
}
