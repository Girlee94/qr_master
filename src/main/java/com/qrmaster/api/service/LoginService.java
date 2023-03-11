package com.qrmaster.api.service;

import com.qrmaster.api.controller.LoginController;
import com.qrmaster.api.dto.MongoDbTestRequestDto;
import com.qrmaster.api.repository.MongoDbTestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginService {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final MongoDbTestRepository mongoDbTestRepository;

    // 이하 작성 시작...
    // jpa는 아직 잘 몰라서 패키지 안만들어놓음

    public String mongoTestFindName(MongoDbTestRequestDto mongoDbTestRequestDto) {

        String testName = mongoDbTestRepository.findByUserid(mongoDbTestRequestDto.getUserid()).getUsername();

        return testName;
    }

}
