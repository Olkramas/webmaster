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


@WebServlet("/MemberAddSelvlet")
public class MemberAddSelvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public MemberAddSelvlet() {
        // TODO Auto-generated constructor stub
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
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("mid");		//mid라는 파라미터 값을 id에 저장했음
		String name = request.getParameter("mname");
		String password = request.getParameter("pass");
		String phone = request.getParameter("phone");
		
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberName(name);
		member.setPassword(password);
		member.setPhone(phone);
		
		//openSession안에 true를 하면 자동 커밋
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		try {
			if(dao.insertMember(member)==1) {
				response.getWriter().print("OK");
			}
		} catch (Exception e) {
			response.getWriter().print("NG");
		}
		
	}

}
