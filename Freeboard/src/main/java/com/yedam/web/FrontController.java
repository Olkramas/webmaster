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

//끝이 .do로 끝나면 이 클래스를 실행하겠다는 의미
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	Map<String, Control> map; 
	//String은 url데이터를 담을거
	
	public FrontController() {
//		System.out.println("객체 생성");
		map = new HashMap<>();

		
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init호출");
		//memberList.do라는 url이 들어오면 MemberListControl작동
		map.put("/memberList.do", new MemberListControl());
		//회원등록 -- 1)등록화면 2)등록처리 두화면이 필요함
		map.put("/memberAddForm.do", new MemberAddFormControl());
		map.put("/memberAdd.do", new MemberAddControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("service호출");
		//요청 페이지가 뭔지 알면 해당 기능을 연결할 수 있음.
		String uri = req.getRequestURI();	//	req.getRequestURI()가 다음을 리턴함 ---> /Freeboard/000.do
		String context = req.getContextPath();	//getContextPath프로젝트 이름을 리턴함 ---> /Freeboard
		String page = uri.substring(context.length());	//	프로젝트 이름 빼고 그 다음으로 모두 가져옴 ---> /000.do
		
		Control control = map.get(page);	//키: page를 넣으면 리턴되는 값을 control에 저장함
		control.exec(req, resp);
		
	}
}
