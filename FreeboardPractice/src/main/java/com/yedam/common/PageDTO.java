package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	
	//현재 페이지
	private int page;
	
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	public PageDTO(int page, int totalCnt) {	
		
		this.page = page;
		
		//현재 페이지가 만약 7이라면 /10.0 (올림값 1) * 10	= "10"이endPage가 됨. 그럼 값이 올라가도 엔드페이지는 10, 20, 30....이 되게 됨.
		//그런데 예외가 7페이지가 끝인데 10페이지까지 있으니까 의미없는 버튼들이 출력되게 됨.
		this.endPage = (int) Math.ceil(page / 10.0) * 10;
		//끝 페이지를 기점으로 -9를 하면 1, 11, 21...이렇게 흘러가게 될 것
		this.startPage = endPage - 9;
		
		//실제 제일 마지막 페이지를 구함 전체게시물 수/5
		int realEnd = (int)	Math.ceil(totalCnt /10.0);
		
		//만약 endPage가 실제 마지막페이지 모다 많다면 endPage는 realEnd가 됨. 그게 아니면 endPage.
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		
		//이전, 다음버튼 참, 거짓 나누기. 
		this.prev = this.startPage>1;
		this.next = this.endPage < realEnd;
		
	}
}
