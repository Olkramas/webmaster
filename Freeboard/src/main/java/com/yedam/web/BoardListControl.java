package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//유저가/boardList.do를 검색했을때 여기를 거치게됨.
		
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		//page가 null일때 1을 넣고 아니면 page그대로를 page에 넣겠다라는 의미
		page = page == null ? "1" : page;
		
		//검색조건을 객체로 만들어서 한번에 넘기기
		SearchDTO search = new SearchDTO();
		search.setKeyword(kw);
		search.setSearchCondition(sc);
		search.setPage(Integer.parseInt(page));
		
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		
		//글목록 보여주기
		//글목록을 조회하고 그 결과를 jsp파일로 전달해야함.(forward 사용)
		
		//조회하는 기능은 컨트롤러 보여지는 페이지는 jsp페이지를 보여줌
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(search);
		//totalCnt
		int totalCnt = svc.getTotalCount(search);
		//getTotalCount원래는 매개값이 없었음 그런데 searchDTO객체를 넣어서 BoardService, BoardServiceImpl가 바뀌는데 이러면 BoardMapper, BoardMapper.xml도 다 바껴야함
		//BoardServiceImpl가 mapper에서 쿼리문을 가져오고 값을 가져오기 때문에
		//mapper기능을 -service에서 호출하고 - service의 기능을 control에서 사용하고 있음. 그래서 control이 바뀌면 service, mapper다 바꿔야함.
		
		req.setAttribute("boardList", list);
		req.setAttribute("page", new PageDTO(Integer.parseInt(page), totalCnt));

		//보여질 jsp페이지 forward를 통해 연결
		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);
	}

}
