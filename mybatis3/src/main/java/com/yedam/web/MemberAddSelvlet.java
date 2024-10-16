package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;
//서블릿 실행을 위한 url이 있어야함.
//응답정보를 전송.
//http 프로토콜을 데이터 전송, 수신
//httpservlet 상속기능 구현

//@WebServlet("/MemberAddSelvlet")요청이 들어오면 해당 서블릿 클래스가 실행이 됨.
@WebServlet("/MemberAddSelvlet")
public class MemberAddSelvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public MemberAddSelvlet() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// 자바 => 데이터 입출력 :스트림
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("<h3>여기는 웹브라우저</h3>");
		out.print("<h3>응답정보를 처리하는 객체: response</h3>");
		out.println("안녕하세용");
		out.print("<a href='index.html'>첫페이지로 이동</a>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 출력을위함
		request.setCharacterEncoding("utf-8");	
		
		String id = request.getParameter("mid");		//memberAdd.html에서 form안에 name
		String name = request.getParameter("mname");
		String password = request.getParameter("pass");
		String phone = request.getParameter("phone");
		
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberName(name);
		member.setPassword(password);
		member.setPhone(phone);
		
		//데이터 베이스 연결을 관리하는 객체를 리턴받았음DataSource.getInstance()
		//openSession(true)새로운 sql세션을 생성하는 메소드, true는 자동 커밋
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		//sqlSession객체에서 .getMapper메소드를 호출하여 MemberMapper인터페이스의 구현체(xml파일)을 가져옴
		//이를 dao라는 객체에 담았기 때문에 dao.~~xml파일에서 정의했던 것들을 사용할 수 있음.
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		if(dao.insertMember(member) == 1) {
			try {
				response.getWriter().print("OK");				
			} catch (Exception e) {
				response.getWriter().print("NG");
			}
		}
		

	}

}
