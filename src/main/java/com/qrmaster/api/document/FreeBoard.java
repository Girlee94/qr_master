package com.qrmaster.api.document;

import com.qrmaster.api.enums.DeleteFlag;
import com.qrmaster.api.enums.converter.DeleteFlagConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Convert;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "freeboard")
public class FreeBoard {
	
	@Id
	String			_id;
	
	long			usridx;
	String			title;
	String			content;
	@Convert(converter = DeleteFlagConverter.class)
	DeleteFlag		deleteFlag;
	LocalDateTime	registerdate;
	LocalDateTime	updatedate;
	
	public static FreeBoard writeFreeboard(long usridx, String title, String content) {
		return FreeBoard.builder()
						.usridx(usridx)
						.title(title)
						.content(content)
						.deleteFlag(DeleteFlag.POST)
						.registerdate(LocalDateTime.now())
						.build();
	}
	
	public void updateFreeboard(String title, String content) {
		this.title		=	title;
		this.content	=	content;
		this.updatedate	=	LocalDateTime.now();
	}
}
