package com.qrmaster.api.entity.maria;

import com.qrmaster.api.enums.Gender;
import com.qrmaster.api.enums.converter.GenderConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long			usr_idx;

	private String			usr_id;
	private String			usr_pw;
	private String			usr_nick;
	@Convert(converter = GenderConverter.class)
	private Gender			gender;
	private LocalDateTime	join_date;
}
