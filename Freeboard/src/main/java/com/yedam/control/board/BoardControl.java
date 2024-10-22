package com.yedam.control.board;

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
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		//url이 board.do가 요청되면 처리할 기능 > 파라미터(bno)가 오면 > 조회 > board.jsp에서 출력
		
		//웹에 name이 bno가 있어야 됨
		String bno = req.getParameter("bno");
		
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.searchBoard(Integer.parseInt(bno));
		
		
		
		//파라미터를 저장하고 board.jsp로 넘겨주기 위해서 속성설정
		req.setAttribute("boardvo", board);
		req.setAttribute("page", page);
		
		//dis치면 다 띄워줌
		req.getRequestDispatcher("board/board.tiles").forward(req, resp);
		
	}

}
