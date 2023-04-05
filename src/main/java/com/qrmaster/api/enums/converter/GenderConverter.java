package com.qrmaster.api.enums.converter;

import com.qrmaster.api.enums.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class GenderConverter implements AttributeConverter<Gender, Byte> {

	@Override
	public Byte convertToDatabaseColumn(Gender attribute) {

		return attribute.getGender();
	}

	@Override
	public Gender convertToEntityAttribute(Byte dbData) {

		return Gender.valueOfGender(dbData);
	}
}
