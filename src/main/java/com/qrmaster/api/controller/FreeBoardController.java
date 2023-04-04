package com.qrmaster.api.controller;

import com.qrmaster.api.service.FreeBoardService;
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
public class FreeBoardController {

	private final FreeBoardService	mpkFreeBoardService;
	
	/**
	 * author : 현경
	 * description : 게시글 리스트
	 * parameter : page
	 */
	@PostMapping("/getlist")
	public HashMap<String, Object> getFreeBoardList(@RequestBody HashMap<String, Object> pkRequest) {
		
		HashMap<String, Object>	pkResponse	=	new HashMap<>();
		
		try {
			if (!pkRequest.containsKey("page") || !StringUtils.hasText(String.valueOf(pkRequest.get("page"))))
			{
				throw new RuntimeException("no parameter");
			}
			
			int	nPage	=	Integer.parseInt(pkRequest.get("page").toString()) - 1;
			
			pkResponse	=	mpkFreeBoardService.getFreeBoardList(nPage);
		}
		catch (RuntimeException ex)
		{
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
	@PostMapping("/write")
	public HashMap<String, Object> writeFreeBoard(@RequestBody HashMap<String, Object> pkRequest) {
		
		HashMap<String, Object>	pkResponse	=	new HashMap<>();
		
		try {
			if ((!pkRequest.containsKey("usridx")	|| !StringUtils.hasText(String.valueOf(pkRequest.get("usridx")))) ||
				(!pkRequest.containsKey("title")	|| !StringUtils.hasText(String.valueOf(pkRequest.get("title")))) ||
				(!pkRequest.containsKey("content")	|| !StringUtils.hasText(String.valueOf(pkRequest.get("content")))))
			{
				throw new RuntimeException("no parameter");
			}
			
			long	nUsrIdx		=	Long.parseLong(pkRequest.get("usridx").toString());
			String	strTitle	=	pkRequest.get("title").toString();
			String	strContent	=	pkRequest.get("content").toString();
			
			pkResponse	=	mpkFreeBoardService.writeFreeBoard(nUsrIdx, strTitle, strContent);
		}
		catch (RuntimeException ex)
		{
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
	@PostMapping("/read")
	public HashMap<String, Object> readFreeBoard(@RequestBody HashMap<String, Object> pkRequest) {
		
		HashMap<String, Object>	pkResponse	=	new HashMap<>();
		
		try {
			if ((!pkRequest.containsKey("_id")	|| !StringUtils.hasText(String.valueOf(pkRequest.get("_id")))))
			{
				throw new RuntimeException("no parameter");
			}
			
			String	strFreeBoardIdx	=	pkRequest.get("_id").toString();
			
			pkResponse	=	mpkFreeBoardService.readFreeBoard(strFreeBoardIdx);
		}
		catch (RuntimeException ex)
		{
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
	@PostMapping("/update")
	public HashMap<String, Object> updateFreeBoard(@RequestBody HashMap<String, Object> pkRequest) {
		
		HashMap<String, Object>	pkResponse	=	new HashMap<>();
		
		try {
			if ((!pkRequest.containsKey("_id")		|| !StringUtils.hasText(String.valueOf(pkRequest.get("_id")))) ||
				(!pkRequest.containsKey("usridx") 	|| !StringUtils.hasText(String.valueOf(pkRequest.get("usridx")))) ||
				(!pkRequest.containsKey("title") 	|| !StringUtils.hasText(String.valueOf(pkRequest.get("title")))) ||
				(!pkRequest.containsKey("content") 	|| !StringUtils.hasText(String.valueOf(pkRequest.get("content")))))
			{
				throw new RuntimeException("no parameter");
			}
			
			String	strFreeBoardIdx	=	pkRequest.get("_id").toString();
			long	nUsrIdx			=	Long.parseLong(pkRequest.get("usridx").toString());
			String	strTitle		=	pkRequest.get("title").toString();
			String	strContent		=	pkRequest.get("content").toString();
			
			pkResponse	=	mpkFreeBoardService.updateFreeBoard(strFreeBoardIdx, nUsrIdx, strTitle, strContent);
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
