package com.qrmaster.api.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "freeboard")
public class Freeboard {
	
	@Id
	String			_id;
	
	long			usridx;
	String			title;
	String			content;
	LocalDateTime	registerdate;
	LocalDateTime	updatedate;
	
	public static Freeboard writeFreeboard(long usridx, String title, String content) {
		return Freeboard.builder()
						.usridx(usridx)
						.title(title)
						.content(content)
						.registerdate(LocalDateTime.now())
						.build();
	}
	
	public void updateFreeboard(String title, String content) {
		this.title		=	title;
		this.content	=	content;
		this.updatedate	=	LocalDateTime.now();
	}
}
