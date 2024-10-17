package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	//생성자에서 필드를 채워주는 작업을 해주고 있음
	//현재 페이지를 기준으로 시작페이지, 마지막페이지를 startPage, endPage변수에 저장함
	private int startPage, endPage;
	private boolean prev, next;
	
	//현재페이지
	private int page;
	
	public PageDTO(int page) {
		//토탈카운트를 기준으로 전체페이지를 만드려고 함
		int totalCnt = 40;
		this.endPage = (int) Math.ceil(page / 10.0) * 10;
		this.startPage = this.endPage - 9;
		
		int realEnd = (int) Math.ceil(totalCnt / 5.0);
		//실제 마지막 페이지보다 endPage가 크면 realEnd로 endPage를 설정하게 됨.
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
	
}
