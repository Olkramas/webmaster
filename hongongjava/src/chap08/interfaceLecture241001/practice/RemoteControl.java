package chap08.interfaceLecture241001.practice;

public interface RemoteControl {
	public final int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;
	
	//method
	public void turnOn();
	public void turnOff();
	public void setVolum(int volume);
}
