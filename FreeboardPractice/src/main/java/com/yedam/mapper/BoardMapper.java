package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardMapper {
	//전체리스트
	List<BoardVO> boardList();
	
	//페이징된 리스트
	List<BoardVO> listWithPage(int page);
	
	//글 등록
	int insertBoard(BoardVO board);
	
	//글 수정
	int updateBoard(BoardVO board);
	
	//글 삭제
	int deleteBoard(int boardNo);
	
	//상세조회.
	BoardVO selectBoard(int boardNo);
	
	//조회수
	int updateCount(int boardNo);
}
