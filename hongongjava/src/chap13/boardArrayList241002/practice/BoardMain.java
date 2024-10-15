package chap13.boardArrayList241002.practice;

import java.util.ArrayList;
import java.util.List;

public class BoardMain {

	public static void main(String[] args) {
		List<Board> list = new ArrayList<>();
		
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		
		list.remove(2);
		list.remove(3);
		
		for(Board ele : list) {
			System.out.println(ele);
		}
		
		for(Board ele : list) {
			System.out.println("제목: " + ele.subject + "내용: " + ele.content + "글쓴이: " + ele.writer);
		}
	}
	

}
