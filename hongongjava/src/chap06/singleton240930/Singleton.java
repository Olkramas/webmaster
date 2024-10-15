package chap06.singleton240930;

public class Singleton {
	//전체 프로그램에서 하나의 객체만 존재하게 하는 코딩 기법	
	//생성자접근 불가하게 만들어야 함. 그래야 다른 객체를 생성하게 할 수 없음 + 필드 접근또한 불가능
	//외부에서 객체를 만들 수 없다는 말은 클래스로 접근해야된다는 말.
	
	//필드
	private static Singleton st = new Singleton();
	String name = "홍길동";
	
	//생성자
	private Singleton() {};
	
	//메소드 : 외부로 객체 전달해야됨.
	static Singleton getinstance() {
		return st;
	}
	
}
