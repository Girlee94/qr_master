package com.qrmaster.api.dto.user;

import com.qrmaster.api.entity.maria.User;
import com.qrmaster.api.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class UserDTO {

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Create {

		private String	usr_id;
		private String	usr_pw;
		private String	usr_nick;
		private String	gender;

		public User	toEntity() {

			return User.builder()
					.usr_id(this.usr_id)
					.usr_pw(this.usr_pw)
					.usr_nick(this.usr_nick)
					.gender(Gender.valueOf(this.gender))
					.join_date(LocalDateTime.now())
					.build();
		}
	}


}
