package com.yedam.mapper;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardMapper {
	
	//페이징 된 리스트 가져오기
	public List<BoardVO> listWithPage(SearchDTO search);
	
	//게시글 업로드
	public int insertBoard(BoardVO board);
	
	//게시글 수정
	public int updateBoard(BoardVO board);
	
	//게시글 삭제
	public int deleteBoard(int boardNum);
	
	//게시글 상세 조회
	public BoardVO selectBoard(int boardNo);
	
	//조회수 올리기 메소드
	int updateCount(int boardNo);
	
	//페이지 계산 건수 체크
	int selectCount(SearchDTO search);
}
