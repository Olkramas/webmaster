package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class Apptest {
	//여기서 중간중간 테스트해볼 수 있음 쿼리를제대로 짰는지 확인가능
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		//insert 실험 필수값들만 넣었음.
//		BoardVO bvo = new BoardVO();
//		bvo.setTitle("mapper테스트");
//		bvo.setContent("정상 작동합니다.");
//		bvo.setWriter("user01");
		//update 실험
//		bvo.setContent("수정) 정상작동합니다");
//		bvo.setWriter("user01");
		//delete 실험
//		bvo.setBoardNo(4);

		
		//insert가 성공하면 1 그럼 커밋
//		if(mapper.insertBoard(bvo) == 1) {
//			sqlSession.commit();
//		}
		//update 실험
//		if(mapper.updateBoard(bvo) == 1) {
//			sqlSession.commit();
//		}
		//delete 실험
//		if(mapper.deleteBoard(bvo.getBoardNo()) == 1) {
//			sqlSession.commit();
//		}
		//단건조회
//		if(mapper.selectBoard(bvo.getBoardNo()) == null) {
//			System.out.println("조회된 내용이 없습니다.");
//		} else {
//			
//		}
//		//select 실험
//		List<BoardVO> list = mapper.boardList();
//		for(BoardVO bvo2 : list) {
//			System.out.println(bvo2.toString());
//		}
		
		//page파라미터를 1로 가정해서 시험
		//리스트를 5개식 가져오기
//		List<BoardVO> list = mapper.listWithPage(6);
//		for(BoardVO bvo : list) {
//			System.out.println(bvo.toString());
//		}
		
		SearchDTO search = new SearchDTO();
		search.setKeyword("user01");
		search.setSearchCondition("W");
		search.setPage(1);
		
		List<BoardVO> list = mapper.listWithPage(search);
		for(BoardVO bvo : list) {
			System.out.println(bvo.toString());
		}
	}
}

