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
	//url경로(String)와 해당경로를 처리할 Control객체를 매핑하는 Map
	Map<String, Control> map; 
	
	//생성자 인스턴스가 생성될 때 호출됨
	public FrontController() {
//		System.out.println("객체 생성");
		map = new HashMap<>();

		
	}
	
	//init은 서버가 처음 실행할 때 한번 실행됨.
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init호출");
		//url경로가 키값으로 해당 url경로를 처리할 컨트롤러 객체를 map에 미리 등록해놓음
		
		//회원 관련 처리
		//memberList.do라는 url이 들어오면 MemberListControl작동
		map.put("/memberList.do", new MemberListControl());
		//회원등록 -- 1)등록화면 2)등록처리 두화면이 필요함
		map.put("/memberAddForm.do", new MemberAddFormControl());
		//등록 처리
		map.put("/memberAdd.do", new MemberAddControl());
		
		//게시글 관련 처리
		//글목록 보여주기
		map.put("/boardList.do", new boardListControl());
		//게시글 상세화면 보기
		map.put("/board.do", new BoardControl());
		//게시글 리스트(등록화면에서 등록처리를 함) 컨트롤이 두개가 있어야 함.
		//등록 화면
		map.put("/addBoardForm.do", new AddBoardForm());
		//등록 처리
		map.put("/addBoard.do", new AddBoardControl());
		//글 수정
		//수정하는 화면이 있어야됨. 그리고 그 화면에서 변경처리를 해야됨.
		map.put("/modifyBoard.do", new ModifyBoardControl());
		//글삭제
		map.put("/deleteBoard.do", new DeleteBoard());
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("service호출");
		//요청 페이지가 뭔지 알면 해당 기능을 연결할 수 있음.
		String uri = req.getRequestURI();	//	req.getRequestURI()가 다음을 리턴함 ---> /Freeboard/000.do
		String context = req.getContextPath();	//getContextPath프로젝트 이름을 리턴함 ---> /Freeboard
		String page = uri.substring(context.length());	//	프로젝트 이름 빼고 그 다음으로 모두 가져옴 ---> /000.do
		
		Control control = map.get(page);	//키: page(url)을 넣으면 그에 해당하는 Control객체를 맵에서 가져오게됨.
		control.exec(req, resp);		//Contrl객체의(위에서 설정한 생성자들의 객체) exec()메소드를 호출하여 요청을 처리함
		
	}
}
