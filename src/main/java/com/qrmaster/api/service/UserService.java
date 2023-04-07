package com.qrmaster.api.service;

import com.qrmaster.api.dto.KeyDTO;
import com.qrmaster.api.dto.user.UserDTO;
import com.qrmaster.api.dto.user.UserProfileDTO;
import com.qrmaster.api.entity.maria.User;
import com.qrmaster.api.repository.maria.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository	userRep;

	public KeyDTO<Long> join(UserDTO.Create user) {

		User	saveUser	=	userRep.save(user.toEntity());

		return KeyDTO.<Long>builder()
				.key(saveUser.getUsr_idx())
				.build();
	}

	public List<UserProfileDTO> findUserProfiles(List<Long> userIdxs) {

		List<User>  users   =   userRep.findByUsrIdxs(userIdxs);

		return users.stream()
				.map(user -> {
					UserProfileDTO  dto =   new UserProfileDTO(user);

					return dto;
				}).collect(Collectors.toList());
	}

}

























