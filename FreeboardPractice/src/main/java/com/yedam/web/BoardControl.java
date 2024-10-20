package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자의 요청에서 파라미터 가져오기
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		String bno = req.getParameter("bno");
		
		//가져온 파라미터 jsp페이지로 보내서 사용하기위해 속성설정
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		BoardService svc = new BoardServiceImpl();
		//게시물 상세보기 객체에 정보 저장 + 조회수 1업 
		BoardVO board = svc.searchBoard(Integer.parseInt(bno));
		
		
		
		
	}

}
