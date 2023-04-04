package com.qrmaster.api.board.enums.converter;

import com.qrmaster.api.board.enums.DeleteFlag;

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
