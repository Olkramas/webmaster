package com.yedam.common;

import java.util.List;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

import lombok.Data;

@Data
public class PageDTO {
	//생성자에서 필드를 채워주는 작업을 해주고 있음
	//현재 페이지를 기준으로 시작페이지, 마지막페이지를 startPage, endPage변수에 저장함
	private int startPage, endPage;
	private boolean prev, next;
	
	//현재페이지
	private int page;
	
	public PageDTO(int page, int totalCnt) {
		BoardService svc = new BoardServiceImpl();
		
		this.page = page;
		
		//토탈카운트를 기준으로 전체페이지를 만드려고 함
//		int totalCnt = svc.getTotalCount();
		this.endPage = (int) Math.ceil(page / 10.0) * 10;
		this.startPage = this.endPage - 9;
		
		//데이터 건수를 계산해서 최종페이지를 가져오면 됨.
		int realEnd = (int) Math.ceil(totalCnt / 5.0);
		
		//실제 마지막 페이지보다 endPage가 크면 realEnd로 endPage를 설정하게 됨.
		//endPage는 로직상 무조건 최소 10을 가지게 되있음. 그러나 realEnd가 더 적을경우 realEnd에 맞게 숫자가 나와야 하기때문에 이렇게 조건을 만들었음
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		
		this.prev = this.startPage > 1;	//이 조건이 되면 true 아니면 false
		this.next = this.endPage < realEnd;
	}
	
}
