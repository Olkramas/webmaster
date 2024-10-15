package chap08.interfaceLecture241001;

public interface RemoteControl {
	//상수
	public int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	
	//메소드(추상메소드만 들어감)
	public void turnOn();
	public void turnOff();
	public void setVolum(int volume);
	
	//추상클래스와 인터페이스의 차이점
	//1. 추상클래스의 메소드는 추상메소드로 만들지 않아도 다똑같이 들어가는 내용은 추상클래스로 만들어야 될 때 추상클래스가 이점을 가짐
	//2. 인터페이스는 하나하나 다 만들어야 함.
}
