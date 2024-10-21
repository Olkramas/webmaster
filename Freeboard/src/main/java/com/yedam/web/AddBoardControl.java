package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청정보에 한글이 포함돼있으면 설정을해줘야함
		req.setCharacterEncoding("utf-8");
		
		//서버상의 저장경로 선언
		String savePath = req.getServletContext().getRealPath("images");
		//최대크기 지정(5mb)
		int maxSize = 1024 * 1024 * 5;
		
		//multipart요청에 대한 처리로 변경
		MultipartRequest mr = new MultipartRequest(//생성자 매개값이 5개가 필요함
				req //1.요청정보
				,savePath	//2.저장경로
				,maxSize	//3.파일 최대 크기 지정
				,"utf-8"	//4. 파일이름에 대한 인코딩타입 지정
				,new DefaultFileRenamePolicy()	  //5.리네임 정책.
				);
		//파일 업로드 하는 작업 완료
		
		//이제 기존 요청에서 가져오는것이 아닌. 멀티파트 요청에서 가져와야함
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String img = mr.getFilesystemName("img");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		board.setImg(img);
		
		BoardService svc = new BoardServiceImpl();
		try {
			//정보가 입력이되면 게시물리스트 페이지로 이동함
			svc.registerBoard(board);
			
			resp.sendRedirect("boardList.do");
		} catch (Exception e) {
			//비정상처리라면 등록화면으로 이동
			
			//구현체의 tbl_boards로 오류가 나게 만들어서 작동이 되는지 확인해봤음.
			req.setAttribute("msg", "등록하는중에 오류가 발생했습니다.");
			req.getRequestDispatcher("WEB-INF/jsp/boardForm.jsp").forward(req, resp);
		}
		
	}

}
