package com.yedam.control.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberJsonCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//회원목록을 json형태로 반환
//		resp.setContentType("text/json;charset=utf-8");
//		
//		MemberService svc = new MemberServiceImpl();
//		List<MemberVO> list = svc.memberList();
//		
//		// [{"memberId": "user01", "memberName": "사용자1" ....}, 
//		// {........}, ...
//		// {........}]
//		
//		 String json = "[";
//	        for (int i = 0; i < list.size(); i++) {
//	            MemberVO member = list.get(i);
//	            json += "{\"memberId\":\"" + member.getMemberId() + 
//                        "\", \"memberName\":\"" + member.getMemberName() + 
//                        "\", \"phone\":\"" + member.getPhone() + "\"}";
//	            if (i != list.size() - 1) {
//	                json += ",";
//	            }
//	        }
//	        json += "]";
//		resp.getWriter().print(json);
		resp.setContentType("text/json;charset=utf-8");	
		
		MemberService svc = new MemberServiceImpl();
		//db에서 유저 리스트 가져오기
		List<MemberVO> list = svc.memberList();
		//요청한 곳으로 제이슨 형태의 데이터를 보내줘야함 그래서 데이터베이스에서 값을 가져오고 제이슨 형태로 작성해서 json변수에 저장하려고 함.
		String json = "[";
		for(int i=0; i<list.size(); i++) {
			//memberList()메소드는 List<MemberVO>타입으로 반환됨 이를 list.get으로 하나의 객체를 가져오려고 함.
			MemberVO member = list.get(i);
			json += "{\"memberId\":\"" + member.getMemberId() +
					"\"," + "\"memberName\":\"" + member.getMemberName() +
					"\"," + "\"phone\":\"" + member.getPhone() + "\"}";
			if(i != list.size()-1) {
				json += ",";
			}
		}
		json += "]";
		//요청을 보낸쪽으로 응답을 전달함
		resp.getWriter().print(json);
				
		
	}
	

}
