package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

//객체 생성 -> init -> service -> destroy 순서를 따라가보는 예시 클래스 파일입니다.

//1 서블릿이 되기 위해 HttpServlet을 상속받아야 함

//2 서블릿이 실행하기 위해 url이 필요함, 정하기 나름임
@WebServlet("/member.action")
public class MemberControlServlet extends HttpServlet {

	// 3 객체 생성(생성자)
	public MemberControlServlet() {
		System.out.println("MemberControlServlet 객체가 생성되었습니다.");
	}

	// 4 최초 요청시 init메소드 실행
	// HttpServlet가 가지고 있는 메소드를 오버라이드
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("최초 요청이면 init 실행됨.");
	}

	// 서블릿을 요청할 때마다 실행
	// HttpServlet가 가지고 있는 메소드를 오버라이드
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HttpServletRequest는 서버에서 정보를 가져옴(요청)
		// HttpServletResponse는 서버로 정보를 보냄 (응답)
		// 여기서 하는 모든 요청과 응답은 서버로 보내고 받는것들.
		// 그 요청과 응답들은 서블릿 컨테이너(톰켓)을 통해서 주고받게됨.

		// if와 elseif둘다 쓰려고 올렸음.
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);

		String id = req.getParameter("mid"); // http://localhost/mybatis3/member.action?mid=user01 (?뒤 값이 파라미터)
		// http://localhost/mybatis3/member.action?mid=user01 파라미터를 직접 보내줌

		System.out.println("서블릿을 요청할때마다 실행");

		resp.setContentType("text/html;charset=utf-8");
		// get: 조회화면, post:삭제처리 //현재 둘다 사용되고 있음 그래서 if문으로 나눴음. 무조건 대문자로 GET / POST써야함
		if (req.getMethod().equals("GET")) {

			// 해당되는 아이디가 없으면 null이 들어옴
			Member member = dao.selectMember(id);

			if (member == null) {
				resp.getWriter().print("조회된 정보가 없습니다.");
				return;
			}

			String str = "<h3>회원정보</h3>";
			str += "<form action='member.action' method='post'>";
			str += "<input type='hidden' name='mid' value='" + member.getMemberId() + "'>";// 파라미터 값을 히든
			str += "<table border='1'>";
			str += "<tr><th>회원 아이디</th><td>" + member.getMemberId() + "</td></tr>";
			str += "<tr><th>회원 이름</th><td>" + member.getMemberName() + "</td></tr>";
			str += "<tr><th>회원 연락처</th><td>" + member.getPhone() + "</td></tr>";
			str += "<tr><td colspan='2'><input type='submit'></td></tr>";
			str += "</table>";
			str += "</form>";
			str += "<a href='MemberListServlet'>목록으로</a>";
			resp.getWriter().print(str);

		} else if (req.getMethod().equals("POST")) { // 삭제처리
			// 삭제가 정상적으로 되면 1리턴받음
			if (dao.deleteMember(id) == 1) {
				resp.getWriter().print("<p>삭제완료</p>");
			} else {
				resp.getWriter().print("<p>삭제할 회원없음.</p>");
			}
			resp.getWriter().print("<a href='MemberListServlet'>목록으로</a>");
		}

	}

	@Override
	public void destroy() {
		System.out.println("서버가 종료될 때 한번 실행");
	}

	// 최초요청시에만 객체가 생성됨
	// 새로고침을 하면 서비스 메소드만 출력이 됨.
}
