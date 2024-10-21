package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class MemberAddFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//인터페이스에서 exec예외를 호출한 곳으로 떠넘기도록 throws를 했음
		
		//getRequestDispatcher이 메소드는 주어진 경로에 대한 Dispatcher객체를 반환함
		//그런데 해당 jsp파일의 경로는 WEB-INF하위 폴더라 url로 접근할 수 없음(폴더 특성이 그럼)
		//forward메소드는 요청과 응답객체를 memberAddForm.jsp로 전달함
		//브라우저의 url은 변경되지 않지만 클라이언트가 원래 요청을 보낸 url이 아닌 jsp페이지로 리디렉션 됨.
		//클라이언트의 요청을 서버는 jsp파일에서 처리를 하는데 클라이언트가 요청한 url은 그대로고 보이는건 jsp페이지에서 처리를 한 결과
		req.getRequestDispatcher("member/memberAddForm.tiles").forward(req, resp);
	}

}
