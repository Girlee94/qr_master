package com.qrmaster.api.controller;

import com.qrmaster.api.dto.MongoDbTestRequestDto;
import com.qrmaster.api.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/login")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final LoginService loginService;

    // 이하 작성 시작할 것...

    @PostMapping("/test")
    public ResponseEntity<?> mongodbTest(@RequestBody MongoDbTestRequestDto mongoDbTestRequestDto) throws Exception {

        String testName = loginService.mongoTestFindName(mongoDbTestRequestDto);

        return ResponseEntity.status(901).body(testName);
    }


}
