package chap06;

public class BoardMain {

	public static void main(String[] args) {
		//메소드 오버라이딩을 통해 같은 클래스로 객체를 생성하고 다른 생성자를 사용할 수 있음. = 결과도 다름
		
		//여러가지 방법으로 객체를 생성하기 위한 방법.
		
		Board board1 = new Board("타이틀1", "콘텐츠1");
		Board board2 = new Board("타이틀2", "콘텐츠2", "writer2");
		Board board3 = new Board("타이틀3", "콘텐츠3", "writer3", "date3");
		Board board4 = new Board("타이틀4", "콘텐츠4", "writer4", "date4", 4);
		//기본생성자가 없는 상태에서
		//Board board5 = new Board();
		Board board5 = new Board();		//이 생성자 안에는 아무것도 안넣어서 기본값이 생성됨.
		board5.title = "제목";
		board5.hitcount = 999;
		
		System.out.println(board1.title + "\t" + board1.content + "\t" + board1.writer + "\t" + board1.date + "\t" + board1.hitcount);
		System.out.println(board2.title + "\t" + board2.content + "\t" + board2.writer + "\t\t" + board2.date + "\t" + board2.hitcount);
		System.out.println(board3.title + "\t" + board3.content + "\t" + board3.writer + "\t\t" + board3.date + "\t\t" + board3.hitcount);
		System.out.println(board4.title + "\t" + board4.content + "\t" + board4.writer + "\t\t" + board4.date + "\t\t" + board4.hitcount);
		System.out.println(board5.title + "\t" + board5.content + "\t" + board5.writer + "\t\t" + board5.date + "\t\t" + board5.hitcount);

	}

}
