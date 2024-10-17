package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청정보에 한글이 포함돼있으면 설정을해줘야함
		req.setCharacterEncoding("utf-8");
		
		// 저장버튼 누르면 title, content, writer3개의 파라미터가 여기로 오게 됨.
		// 그리고 그 파라미터를 가지고 insert를 해야됨(db에 넣기 위해서)
		// db에 등록하고 그 결과를 목록으로 보여주기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		BoardService svc = new BoardServiceImpl();
		try {
			//정보가 입력이되면 게시물리스트 페이지로 이동함
			svc.registerBoard(board);
			
			resp.sendRedirect("boardList.do");
		} catch (Exception e) {
			//비정상처리라면 등록화면으로 이동
			
			//구현체의 tbl_boards로 오류가 나게 만들어서 작동이 되는지 확인해봤음.
			req.setAttribute("msg", "등록하는중에 오류가 발생했습니다.");
			req.getRequestDispatcher("WEB-INF/jsp/boardForm.jsp").forward(req, resp);
		}
		
	}

}
