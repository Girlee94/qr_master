package com.qrmaster.api.exceptions.data;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionCode {
	
	NO_PARAMETER(HttpStatus.NOT_FOUND, 100, "no parameter"),
	
	MEMBER_INVALID(HttpStatus.BAD_REQUEST, 200, "no member"),
	MEMBER_AUTHORIZATION(HttpStatus.UNAUTHORIZED, 201, "no authorization");
	
	private final HttpStatus	status;
	private final int			code;
	private final String		message;
	
	ExceptionCode(HttpStatus status, int code, String message) {
		
		this.status		=	status;
		this.code		=	code;
		this.message	=	message;
	}
	
	
}
