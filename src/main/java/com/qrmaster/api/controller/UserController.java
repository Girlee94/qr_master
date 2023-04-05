package com.qrmaster.api.controller;

import com.qrmaster.api.dto.KeyDto;
import com.qrmaster.api.dto.user.UserDto;
import com.qrmaster.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService	userService;

	@PostMapping
	public ResponseEntity<KeyDto<Long>> join(@RequestBody UserDto.Create user){

		return ResponseEntity.ok()
				.body(userService.join(user));
	}
}
