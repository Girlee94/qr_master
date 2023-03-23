package com.qrmaster.api.enums.converter;

import com.qrmaster.api.enums.DeleteFlag;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DeleteFlagConverter implements AttributeConverter<DeleteFlag, Byte> {
	
	@Override
	public Byte convertToDatabaseColumn(DeleteFlag attribute) {
		
		return attribute.getDeleteFlag();
	}
	
	@Override
	public DeleteFlag convertToEntityAttribute(Byte dbData) {
		
		return DeleteFlag.valueOfDeleteFlag(dbData);
	}
}
