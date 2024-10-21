package com.yedam.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get방식의 요청이 들어오면 수정화면
		// post방식이면 수정처리
		req.setCharacterEncoding("utf-8");
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		BoardService svc = new BoardServiceImpl();
		
		
		if (req.getMethod().equals("GET")) {
			//get방식 요청이 들어오면 아래
			//주소창에 url치면
			// modifyForm.jsp의 결과를 보여줌
			BoardVO board = svc.searchBoard(Integer.parseInt(bno));
			
			req.setAttribute("boardvo", board);
			req.setAttribute("page", page);
			req.setAttribute("searchCondition", sc);
			req.setAttribute("keyword", kw);
			req.getRequestDispatcher("board/modifyForm.tiles").forward(req, resp);
		} else if (req.getMethod().equals("POST")) {
			//ModifyForm에서 서브밋을 누르면 여기로 파라미터 오게됨.
			//post요청에서는 한글처리를 해줘야함
			
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			BoardVO board = new BoardVO();
			board.setBoardNo(Integer.parseInt(bno));
			board.setTitle(title);
			board.setContent(content);
			
			String encodedSc = URLEncoder.encode(sc, "UTF-8"); // searchCondition 인코딩
			String encodedKw = URLEncoder.encode(kw, "UTF-8"); // keyword 인코딩
			
			//인서트는 not null인 항목에 안넣거나 하면 예외가 발생하지만
			//여기서는 그렇게 될게 없음 그래서 if문 사용함
			if(svc.modifyBoard(board)) {
				//수정이 되면 boardList.do로 이동됨(목록을 보여줌)
				resp.sendRedirect("boardList.do?page=" + page + "&searchCondition=" + encodedSc+ "&keyword=" + encodedKw);
			} else {
				req.setAttribute("boardvo", board);
				req.setAttribute("msg", "수정할 게시글이 없습니다");
				req.getRequestDispatcher("board/modifyForm.tiles").forward(req, resp);
			}
		}
	}

}
