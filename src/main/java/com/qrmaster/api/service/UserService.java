package com.qrmaster.api.service;

import com.qrmaster.api.dto.KeyDto;
import com.qrmaster.api.dto.user.UserDto;
import com.qrmaster.api.entity.maria.User;
import com.qrmaster.api.repository.maria.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository	userRepository;

	public KeyDto<Long> join(UserDto.Create user) {

		User	saveUser	=	userRepository.save(user.toEntity());

		return KeyDto.<Long>builder()
				.key(saveUser.getUsr_idx())
				.build();
	}
}
