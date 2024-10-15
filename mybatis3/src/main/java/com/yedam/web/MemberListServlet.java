package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String printList = "";
       
    public MemberListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=utf-8");
        
    	//?
    	PrintWriter out = response.getWriter();
    	
    	SqlSession sqlSession = DataSource.getInstance().openSession(true);
    	MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
    	
    	List<Member> memberList = dao.members();
    	for(Member member : memberList) {
    		out.println("<ol>");
    		out.println("<li> 회원ID: " + member.getMemberId() + "</li>"
    				+ "<li> 회원이름: " + member.getMemberName() + "</li>"
    				+ "<li> 연락처: " + member.getPhone() + "</li>");
    		out.println("</ol>");
    	}
    	out.println("<table>");
    	for(Member member : memberList) {
    		out.print("<tr>");
    		out.println("<td> 회원ID: " + member.getMemberId() + "</td>"
    				+ "<td> 회원이름: " + member.getMemberName() + "</td>"
    				+ "<td> 연락처: " + member.getPhone() + "</td>");
    		out.print("</tr>");
    	}
    	out.println("</table>");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	

}
