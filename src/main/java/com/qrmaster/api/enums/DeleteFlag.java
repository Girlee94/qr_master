package com.qrmaster.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.NoSuchElementException;

@Getter
@AllArgsConstructor
public enum DeleteFlag {
    POST((byte)1),
    DELETE((byte)0);

    private final byte	deleteFlag;

    public static DeleteFlag valueOfDeleteFlag(byte deleteFlag) {

        return Arrays.stream(DeleteFlag.values())
                .filter(v -> v.getDeleteFlag() == deleteFlag)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
