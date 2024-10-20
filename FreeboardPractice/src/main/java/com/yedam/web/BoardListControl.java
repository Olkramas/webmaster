package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//유저가 요청한 파라미터 변수에 저장하기
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		//page가 만약 널이면 1을 변수에 저장하고 그외는 그대로
		page = page == null ? "1" : page;
		
		//검색 점보를 담기위한 객체변수 선언 + setter사용해서 값 객체에 저장하기
		SearchDTO search = new SearchDTO();
		search.setKeyword(kw);
		search.setSearchCondition(sc);
		search.setPage(Integer.parseInt(page));
		
		//기능사용을 위한 인터페이스 객체 선언
		BoardService svc = new BoardServiceImpl();
		
		//게시글 리스트 리턴받기
		List<BoardVO> list = svc.boardList(search);
		
		//실제 게시글의 수를 리턴받음
		int totalCnt = svc.getTotalCount(search);
		
		//사용자의 요청에 이동하는 페이지(jsp)에서 게시물 리스트와 페이징을 하기위해서 속성설정
		req.setAttribute("boardList", list);
		req.setAttribute("page", new PageDTO(Integer.parseInt(page),totalCnt));
		
		//.do 요정을 jsp페이지로 연결하기
		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);
		
		
	}

}
