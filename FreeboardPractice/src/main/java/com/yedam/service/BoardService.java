package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardService {
	//게시물 리스트
	List<BoardVO> boardList(SearchDTO search);
	
	//게시물 등록
	boolean registerBoard(BoardVO board);
	
	//게시물 제거
	boolean removeBoard(int boardNO);
	
	//게시물 수정
	boolean modifyBoard(BoardVO board);
	
	//게시물 상세보기 + 게시물 조회수 업
	BoardVO searchBoard(int boardNo);
	
	//검색 결과에 따라 총 게시글이 몇개인지 리턴
	int getTotalCount(SearchDTO search);
}
