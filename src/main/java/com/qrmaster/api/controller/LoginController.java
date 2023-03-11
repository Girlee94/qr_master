package com.qrmaster.api.controller;

import com.qrmaster.api.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

}
