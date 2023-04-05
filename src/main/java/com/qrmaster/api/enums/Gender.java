package com.qrmaster.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.NoSuchElementException;

@Getter
@AllArgsConstructor
public enum Gender {

	NONE((byte)0),
	MAN((byte)1),
	WOMAN((byte)2);

	private final byte	gender;

	public static Gender valueOfGender(byte gender) {

		return Arrays.stream(Gender.values())
				.filter(g -> g.getGender() == gender)
				.findAny()
				.orElseThrow(NoSuchElementException::new);
	}
}
