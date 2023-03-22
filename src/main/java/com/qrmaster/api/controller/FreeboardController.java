package com.qrmaster.api.controller;

import com.qrmaster.api.service.FreeboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/freeboard")
public class FreeboardController {
	
	private final FreeboardService	mpkFreeboardService;
	
	@PostMapping("/write")
	public HashMap<String, Object> writeFreeboard(@RequestBody HashMap<String, Object> pkRequest) {
		
		HashMap<String, Object>	pkResponse	=	new HashMap<>();
		
		try {
			if ((!pkRequest.containsKey("usridx")	|| !StringUtils.hasText(String.valueOf(pkRequest.get("usridx")))) ||
				(!pkRequest.containsKey("title")	|| !StringUtils.hasText(String.valueOf(pkRequest.get("title")))) ||
				(!pkRequest.containsKey("content")	|| !StringUtils.hasText(String.valueOf(pkRequest.get("content")))))
			{
				throw new RuntimeException("no parameter");
			}
			
			long	nUsridx		=	Long.parseLong(pkRequest.get("usridx").toString());
			String	strTitle	=	pkRequest.get("title").toString();
			String	strContent	=	pkRequest.get("content").toString();
			
			pkResponse	=	mpkFreeboardService.writeFreeboard(nUsridx, strTitle, strContent);
		}
		catch (RuntimeException ex) {
			
			pkResponse.put("result", "failed");
			pkResponse.put("errtype", "runtime exception");
			pkResponse.put("errmsg", ex.getMessage());
		}
		
		return pkResponse;
	}
}
