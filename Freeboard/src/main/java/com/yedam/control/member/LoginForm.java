package com.yedam.control.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//로그인할 때 받아오는 파라미터 받아오기
		String id = req.getParameter("logId");
		String pw =req.getParameter("logPw");
		
		if(req.getMethod().equals("GET")) {
			//페이지 연결
			req.getRequestDispatcher("WEB-INF/jsp/logForm.jsp").forward(req, resp);
		} else if(req.getMethod().equals("POST")) {
			
			MemberService svc = new MemberServiceImpl();
			
			MemberVO member = svc.loginCheck(id, pw);
			//로그인 실패
			if(member == null) {
				//로그인 시도를 했는데 아이디와 비밀번호의 결과가 없을경우 페이지를 다시열고 메소드 종료
				req.setAttribute("msg", "아이디와 비밀번호를 확인하세요");
				req.getRequestDispatcher("WEB-INF/jsp/logForm.jsp").forward(req, resp);
				return;
			}
			//정상 로그인. session객체 (데이터베이스 세션이 아님. 서블릿에서 관리하는 session임)
			HttpSession session = req.getSession();
			//로그인했던 아이디 값을 세션에 담아줌
			//이는 요청할때 받아오고 생명이 끝나는 request객체와 다르게 웹을 종료하기 전에, 세션을 임의로 종료하기 전에 사라지지 않음.
			session.setAttribute("logId", id);
			session.setAttribute("logPw", pw);
			if(member.getResponsibility().equals("User")) {
				resp.sendRedirect("boardList.do");
			}	else if(member.getResponsibility().equals("Admin")) {
				resp.sendRedirect("memberList.do");
			}
			
			
		}
	}

}
