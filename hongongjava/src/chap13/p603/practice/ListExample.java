package chap13.p603.practice;

import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		BoardDao board = new BoardDao();
		
		List<Board> list = board.getBoardList();
		for(Board ele : list) {
			System.out.println(ele.getTitle() + "-" + ele.getcontent());
		}
		
		
		
	}

}
