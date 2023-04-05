package com.qrmaster.api.entity.maria;

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
	private LocalDateTime	join_date;
}
