package com.qrmaster.api.dto.user;

import com.qrmaster.api.entity.maria.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDTO {

	private long    usr_idx;
	private String  usr_nick;

	public UserProfileDTO(User user) {
		this.usr_idx    =   user.getUsr_idx();
		this.usr_nick   =   user.getUsr_nick();
	}
}
