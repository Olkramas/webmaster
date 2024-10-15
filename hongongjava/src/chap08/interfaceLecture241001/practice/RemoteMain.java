package chap08.interfaceLecture241001.practice;

public class RemoteMain {

	public static void main(String[] args) {
		RemoteControl rc = null;
		
		rc = new Audio();
		rc.setVolum(50);
		rc.setVolum(-10);
		rc.setVolum(7);
		
		rc = new Tv();
		rc.setVolum(50);
		rc.setVolum(-10);
		rc.setVolum(7);
		
	}

}
