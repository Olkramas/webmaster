package chap13.p603;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	
	List<Board> list = new ArrayList<Board>();
	

	public List<Board> getBoardList() {
		list.add(new Board("제목1", "내용1"));
		list.add(new Board("제목2", "내용2"));
		list.add(new Board("제목3", "내용3"));
		
		return list;
	}
}
