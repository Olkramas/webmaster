package chap13.boardArrayList241002;

import java.util.List;
import java.util.Vector;

public class BoardMain {

	public static void main(String[] args) {
		//Vector : 멀티스레드 환경에 안전
		
		List<Board> list = new Vector<Board>();
		
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		
		//배열안에 넣어서 자동ㅇ
//		for(int i=1; i<=5; i++) {
//			String title = "제목" + i;
//			String content = "내용" + i;
//			String writer = "글쓴이" + i;
//			list.add(new Board(title,content,writer));
//		}
		
		list.remove(2);		//글쓴이 3이 삭제됨
		list.remove(3);		//배열 번호가 당겨져서 글쓴이5가 삭제됨.
		
		for(Board ele : list) {
			System.out.println("제목: " + ele.subject + "\t내용: " + ele.content + "\t글쓴이: " + ele.writer);
		}
		
		Board bd = new Board("제목", "내용", "글쓴이");
		//println은 객체 참조변수를 출력할 때 toString()가져와서 사용함. 그래서 toString을 재정의 하면 다르게 사용할 수 있음.
		System.out.println(bd);
		System.out.println(bd.hashCode());
		System.out.println(bd.toString());
	}

}
