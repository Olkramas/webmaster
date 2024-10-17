package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class boardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		//page가 null일때 1을 넣고 아니면 page그대로를 page에 넣겠다라는 의미
		page = page == null ? "1" : page;
		
		//글목록 보여주기
		//글목록을 조회하고 그 결과를 jsp파일로 전달해야함.(forward 사용)
		
		//조회하는 기능은 컨트롤러 보여지는 페이지는 jsp페이지를 보여줌
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(Integer.parseInt(page));
		
		req.setAttribute("boardList", list);
		req.setAttribute("page", new PageDTO(Integer.parseInt(page)));

		//보여질 jsp페이지 forward를 통해 연결
		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);
	}

}
