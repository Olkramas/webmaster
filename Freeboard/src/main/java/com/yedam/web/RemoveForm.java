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

public class RemoveForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		BoardService svc = new BoardServiceImpl();
		
//		if(req.getMethod().equals("GET")) {
//			svc.removeBoard(Integer.parseInt(bno));
//			resp.sendRedirect("boardList.do");
//		}
		if(req.getMethod().equals("GET")) {
			BoardVO board = svc.searchBoard(Integer.parseInt(bno));
			
			req.setAttribute("boardvo", board);
			req.setAttribute("page", page);
			req.setAttribute("searchCondition", sc);
			req.setAttribute("keyword", kw);
			req.getRequestDispatcher("WEB-INF/jsp/removeForm.jsp").forward(req, resp);
		} else if(req.getMethod().equals("POST")) {
			System.out.println("Method: " + req.getMethod());
			System.out.println("sc : "+ sc);
			System.out.println("kw : "+ kw);					//출력결과 : 테스트
			System.out.println("page : "+ page);
			String encodedSc = URLEncoder.encode(sc, "UTF-8"); // searchCondition 인코딩
			String encodedKw = URLEncoder.encode(kw, "UTF-8"); // keyword 인코딩
			System.out.println("encodedSc: " + encodedSc);
			System.out.println("encodedkw: " + encodedKw);		//출력결과 : %ED%85%8C%EC%8A%A4%ED%8A%B8
			if(svc.removeBoard(Integer.parseInt(bno))) {
				//수정이 되면 boardList.do로 이동됨(목록을 보여줌)
				
//				resp.sendRedirect("boardList.do?page=" + page);
				resp.sendRedirect("boardList.do?page=" +page +"&searchCondition=" + encodedSc+ "&keyword=" + encodedKw);					

			} else {
				req.setAttribute("msg", "삭제할 게시글이 없습니다");
				req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);
			}	
		}
		
	}

}
