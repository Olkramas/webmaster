package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class RemoveBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String bno = req.getParameter("bno");
		BoardService svc = new BoardServiceImpl();
		
//		if(req.getMethod().equals("GET")) {
//			svc.removeBoard(Integer.parseInt(bno));
//			resp.sendRedirect("boardList.do");
//		}
		
		if(req.getMethod().equals("GET")) {
			BoardVO board = svc.searchBoard(Integer.parseInt(bno));
			
			req.setAttribute("boardvo", board);
			req.getRequestDispatcher("WEB-INF/jsp/removeForm.jsp").forward(req, resp);
		} else if(req.getMethod().equals("POST")) {
			
			if(svc.removeBoard(Integer.parseInt(bno))) {
				//수정이 되면 boardList.do로 이동됨(목록을 보여줌)
				resp.sendRedirect("boardList.do");
			} else {
				req.setAttribute("msg", "삭제할 게시글이 없습니다");
				req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);
			}	
		}
		
	}

}
