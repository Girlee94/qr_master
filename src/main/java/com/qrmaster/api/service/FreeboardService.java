package com.qrmaster.api.service;

import com.qrmaster.api.document.Freeboard;
import com.qrmaster.api.mongorepository.FreeboardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class FreeboardService {

	private final FreeboardRepository	mpkFreeboardRep;
	
	/**
	 * author : 현경
	 * description : 게시판 작성
	 * parameter : usridx, title, content
	 */
	public HashMap<String, Object> writeFreeboard(long usrIdx, String title, String content) {
		
		HashMap<String, Object>	pkResponse	=	new HashMap<>();
		
		try {
			Freeboard	pkSaveData	=	mpkFreeboardRep.save(Freeboard.writeFreeboard(usrIdx, title, content));
			
			pkResponse.put("result", "success");
			pkResponse.put("errtype", "no error");
			pkResponse.put("freeboardidx", pkSaveData.get_id());
		}
		catch (RuntimeException ex) {
			
			pkResponse.put("result", "failed");
			pkResponse.put("errtype", "runtime exception");
			pkResponse.put("errmsg", ex.getMessage());
		}
		
		return pkResponse;
	}
	
	/**
	 * author : 현경
	 * description : 게시판 수정
	 * parameter : freeboardidx, usridx, title, content
	 */
	public HashMap<String, Object> updateFreeboard(String freeBoardIdx, long usrIdx, String title, String content) {
	
		HashMap<String, Object>	pkResponse	=	new HashMap<>();
		
		try {
			//권한 체크
			Freeboard	pkCheckAuth	=	mpkFreeboardRep.findBy_idAndUsridx(freeBoardIdx, usrIdx)
														.orElseThrow(() -> new NullPointerException("no freeboard"));
			
			pkCheckAuth.updateFreeboard(title, content);
			mpkFreeboardRep.save(pkCheckAuth);
			
			pkResponse.put("result", "success");
			pkResponse.put("errtype", "no error");
		}
		catch (RuntimeException ex)
		{
			pkResponse.put("result", "failed");
			pkResponse.put("errtype", "runtime exception");
			pkResponse.put("errmsg", ex.getMessage());
		}
		
		return pkResponse;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
