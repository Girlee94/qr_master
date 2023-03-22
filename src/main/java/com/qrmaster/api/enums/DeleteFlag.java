package com.qrmaster.api.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum DeleteFlag {
	POST((byte)1),
	DELETE((byte)0);
	
	private final byte	deleteFlag;
	
	DeleteFlag(byte deleteFlag) {
		this.deleteFlag	=	deleteFlag;
	}
	
	public static DeleteFlag valueOfNum(byte deleteFlag) {
		return Arrays.stream(values())
			.filter(value -> value.deleteFlag == deleteFlag)
			.findAny()
			.orElse(null);
	}
}
