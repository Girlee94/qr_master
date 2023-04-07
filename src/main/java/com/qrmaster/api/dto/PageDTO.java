package com.qrmaster.api.dto;

import com.qrmaster.api.dto.board.response.GetBoardListDTO;
import com.qrmaster.api.entity.mongo.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDTO<T> {

	private long    totalElements;  //전체 데이터 개수
	private int     totalPages;     //전체 페이지 수
	private int     size;           //한 페이지당 데이터 개수
	private List<T> list;

	public PageDTO(Page<Board> boardPage, List<T> list) {
		this.totalElements  =   boardPage.getTotalElements();
		this.totalPages     =   boardPage.getTotalPages();
		this.size           =   boardPage.getSize();
		this.list           =   list;
	}
}
