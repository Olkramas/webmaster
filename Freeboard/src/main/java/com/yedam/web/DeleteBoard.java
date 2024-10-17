package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class DeleteBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String bno = req.getParameter("bno");
		BoardService svc = new BoardServiceImpl();
		
		if(req.getMethod().equals("GET")) {
			svc.removeBoard(Integer.parseInt(bno));
			resp.sendRedirect("boardList.do");
		}
		
		//집에서 해봐야됨. 수정처럼 페이지 하나 거쳐서 삭제하기
//		if(req.getMethod().equals("GET")) {
//			req.setAttribute("bno", bno);
//			req.getRequestDispatcher("WEB-INF/jsp/removeForm.jsp").forward(req, resp);
//		} else if(req.getMethod().equals("POST")) {
//			if(svc.removeBoard(Integer.parseInt(bno))) {
//				resp.sendRedirect("boardList.do");
//			} else {
//				
//			}
//		}
	}

}
