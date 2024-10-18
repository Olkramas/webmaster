package com.yedam.mapper;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardMapper {
	//xml의 id와 메소드 이름을 매칭시켜줘야힘
	//글목록
//	List<BoardVO> boardList();
	
	//페이징 된 리스트
	List<BoardVO> listWithPage(SearchDTO search);
	//글등록
	int insertBoard(BoardVO board);
	
	//글수정
	int updateBoard(BoardVO board);
	
	//글삭제
	int deleteBoard(int boardNo);
	
	//상세조회.
	BoardVO selectBoard(int boardNo);
	
	//조회수
	int updateCount(int boardNo);
	
	//페이징 계산 건수 체그
	int selectCount(SearchDTO search);
	
}
