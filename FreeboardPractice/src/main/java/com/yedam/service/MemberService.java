package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface MemberService {
	List<BoardVO> boardList();
	
	int insertBoard(BoardVO board);
	
	int updateBoard(BoardVO board);
	
	int deleteBoard(int boardNo);
	
	BoardVO selectBoard(int boardNo);
}
