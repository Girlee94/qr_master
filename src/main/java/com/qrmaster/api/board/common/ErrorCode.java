package com.qrmaster.api.board.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@JsonFormat(shape = Shape.OBJECT)
public enum ErrorCode{

    // COMMON
    SUCCESS_CODE(200, "C001", "no error"),
    INVALID_PARAMETER(400, "C001", "invalid parameter"),
    PERMISSION_FORBIDDEN(403, "C002", "forbidden error")
    ;

    private int status;
    private String code;
    private String message;
    private String detail;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public int getKey() {
        return this.status;
    }

    public String getValue() {
        return this.message;
    }

}
