package com.qrmaster.api.enums;

import lombok.Getter;

@Getter
public enum DeleteFlag {
	POST((byte)1),
	DELETE((byte)0);
	
	private final byte	deleteFlag;
	
	DeleteFlag(byte deleteFlag) {
		this.deleteFlag	=	deleteFlag;
	}
	
}
