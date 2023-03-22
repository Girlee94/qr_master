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
	
	public HashMap<String, Object> writeFreeboard(long nUsridx, String strTitle, String strContent) {
		
		HashMap<String, Object>	pkResponse	=	new HashMap<>();
		
		try {
			Freeboard	pkSaveData	=	mpkFreeboardRep.save(Freeboard.writeFreeboard(nUsridx, strTitle, strContent));
			
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
}
