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

import com.yedam.comm.Control;

@WebServlet("*.do")
//public class FrontController extends HttpServlet{
//	Map<String, Control> map;
//	
//	public FrontController() {
//		System.out.println("객체 생성");
//		map = new HashMap<>();
//	}
//	
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		System.out.println("init 호출");
//		map.put("/memberList.do", new MemberListControl());
//		map.put("/memberAddForm.do", new MemberAddFormControl());
//		map.put("/memberAdd.do", new MemberAddControl());
//	}
//	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("service호출");
//		String uri = req.getRequestURI();
//		String context = req.getContextPath();
//		String page = uri.substring(context.length());
//		
//		Control control = map.get(page);
//		control.exec(req, resp);
//	}
//}\
	public class FrontController extends HttpServlet{
		//요청 url과 맞는 처리를 해줘야 해서 map
		Map<String, Control> map;
		
		public FrontController() {
			System.out.println("객체 생성");
			map = new HashMap<>();
		}
		
		@Override
		public void init(ServletConfig config) throws ServletException {
			System.out.println("init 호출");
			map.put("/memberList.do", new MemberListControl());
		}
		
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("survice 호출");
			String uri = req.getRequestURI();
			String context = req.getContextPath();
			String page = uri.substring(context.length());
			
			Control control = map.get(page);
			control.exec(req, resp);
	}
}
