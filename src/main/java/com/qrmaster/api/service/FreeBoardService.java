package com.qrmaster.api.service;

import com.qrmaster.api.document.FreeBoard;
import com.qrmaster.api.enums.DeleteFlag;
import com.qrmaster.api.mongorepository.FreeBoardRepository;
import com.qrmaster.api.utils.EBUtilLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FreeBoardService {

	private final FreeBoardRepository	mpkFreeBoardRep;
	
	/**
	 * author : 현경
	 * description : 게시글 리스트
	 * parameter : page
	 */
	public HashMap<String, Object> getFreeBoardList(int page) {
		
		HashMap<String, Object>	pkResponse	=	new HashMap<>();
		
		try {
			Page<FreeBoard>	pkFreeBoardData	=	mpkFreeBoardRep.findAllByDeleteFlag(DeleteFlag.POST, PageRequest.of(page, 10));
			
			long	nTotalCount	=	pkFreeBoardData.getTotalElements();
			
			List<FreeBoard>	pkFreeBoardList	=	pkFreeBoardData.stream().collect(Collectors.toList());
			
			pkResponse.put("result", "success");
			pkResponse.put("errtype", "no error");
			pkResponse.put("freeboardlist", pkFreeBoardList);
			pkResponse.put("total", nTotalCount);
		}
		catch (RuntimeException ex)
		{
			EBUtilLogger.getLooger().error(ex.getMessage());
			
			pkResponse.put("result", "failed");
			pkResponse.put("errtype", "runtime exception");
			pkResponse.put("errmsg", ex.getMessage());
		}
		
		return pkResponse;
	}
	
	/**
	 * author : 현경
	 * description : 게시글 작성
	 * parameter : usridx, title, content
	 */
	public HashMap<String, Object> writeFreeBoard(long usrIdx, String title, String content) {
		
		HashMap<String, Object>	pkResponse	=	new HashMap<>();
		
		try {
			FreeBoard pkSaveData	=	mpkFreeBoardRep.save(FreeBoard.writeFreeBoard(usrIdx, title, content));
			
			pkResponse.put("result", "success");
			pkResponse.put("errtype", "no error");
			pkResponse.put("_id", pkSaveData.get_id());
		}
		catch (RuntimeException ex)
		{
			EBUtilLogger.getLooger().error(ex.getMessage());
			
			pkResponse.put("result", "failed");
			pkResponse.put("errtype", "runtime exception");
			pkResponse.put("errmsg", ex.getMessage());
		}
		
		return pkResponse;
	}
	
	/**
	 * author : 현경
	 * description : 게시글 읽기
	 * parameter : _id
	 */
	public HashMap<String, Object> readFreeBoard(String freeBoardIdx) {
		
		HashMap<String, Object>	pkResponse	=	new HashMap<>();
		
		try {
			FreeBoard	pkFreeBoard	=	mpkFreeBoardRep.findBy_idAndDeleteFlag(freeBoardIdx, DeleteFlag.POST)
													.orElseThrow(NullPointerException::new);
			
			pkResponse.put("result", "success");
			pkResponse.put("errtype", "no error");
			pkResponse.put("freeboard", pkFreeBoard);
		}
		catch (RuntimeException ex)
		{
			EBUtilLogger.getLooger().error(ex.getMessage());
			
			pkResponse.put("result", "failed");
			pkResponse.put("errtype", "runtime exception");
			pkResponse.put("errmsg", ex.getMessage());
		}
		
		return pkResponse;
	}
	
	/**
	 * author : 현경
	 * description : 게시글 수정
	 * parameter : freeboardidx, usridx, title, content
	 */
	public HashMap<String, Object> updateFreeBoard(String freeBoardIdx, long usrIdx, String title, String content) {
	
		HashMap<String, Object>	pkResponse	=	new HashMap<>();
		
		try {
			//권한 체크
			FreeBoard pkCheckAuth	=	mpkFreeBoardRep.findBy_idAndUsridx(freeBoardIdx, usrIdx)
														.orElseThrow(() -> new NullPointerException("no freeboard"));
			
			pkCheckAuth.updateFreeBoard(title, content);
			mpkFreeBoardRep.save(pkCheckAuth);
			
			pkResponse.put("result", "success");
			pkResponse.put("errtype", "no error");
		}
		catch (RuntimeException ex)
		{
			EBUtilLogger.getLooger().error(ex.getMessage());
			
			pkResponse.put("result", "failed");
			pkResponse.put("errtype", "runtime exception");
			pkResponse.put("errmsg", ex.getMessage());
		}
		
		return pkResponse;
	}
	
}
