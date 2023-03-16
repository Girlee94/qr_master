package com.qrmaster.api.board.validation;

import com.qrmaster.api.board.dto.BoardDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class BoardValidation {
    public void validate(BoardDto boardDto, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "", "제목을 입력해주세요.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contents", "", "내용을 입력해주세요.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "", "작성자를 입력해주세요.");
    }
}
