package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

@WebServlet("*.do")
public class FrontController extends HttpServlet{
	//mapper - service 순서로 먼저 만들어져야함.
	
	Map<String, Control> map;
	
	public FrontController() {
		System.out.println("객체 생성");
		map = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 호출");
		//멤버 리스트 출력
		map.put("/memberList.do", new MemberListControl());
		//멤버 추가 jsp연결
		map.put("/memberAddForm.do", new MemberAddFormControl());
		//멤버 추가 실제 처리
		map.put("/memberAdd.do", new MemberAddControl());
		
		//게시글 리스트보기
		map.put("/boardList.do", new BoardListControl());
		//게시글 상세보기
		map.put("/board.do", new BoardControl());
		
	
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service호출");
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String page = uri.substring(context.length());
		
		Control control = map.get(page);
		control.exec(req, resp);
	}
}
