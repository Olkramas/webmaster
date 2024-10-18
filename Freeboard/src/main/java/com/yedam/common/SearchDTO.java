package com.yedam.common;

import lombok.Data;

@Data
public class SearchDTO {
//	String page = req.getParameter("page");
//	String sc = req.getParameter("searchCondition");
//	String kw = req.getParameter("keyword");
	//위 파라미터들을 가져와서 객체로 넘겨주기 위한 클래스
	
	private int page;
	private String searchCondition;
	private String keyword;
	
}
