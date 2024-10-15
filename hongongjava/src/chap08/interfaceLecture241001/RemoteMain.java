package chap08.interfaceLecture241001;

public class RemoteMain {

	public static void main(String[] args) {
		//인터페이스 타입 변수에 객체 만들기
		RemoteControl rc;
		rc = new Tv();
		rc.setVolum(50);
		rc.setVolum(-5);
		rc.setVolum(7);
		
		rc = new Audio();
		rc.setVolum(50);
		rc.setVolum(-5);
		rc.setVolum(7);
		
	}

}
