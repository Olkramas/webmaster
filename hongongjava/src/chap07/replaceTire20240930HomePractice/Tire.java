package chap07.replaceTire20240930HomePractice;

public class Tire {
	//타이어 객체를 만들기위한 클래스
	
	//최대회전수
	public int maxRotation;
	//회전누적수
	public int accumulatedRotation;
	//타이어 위치
	public String location;
	
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	public boolean roll() {
		accumulatedRotation++;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + "Tire 수명: " + (maxRotation - accumulatedRotation) + "회");
			return true;
		} else {
			System.out.println("*** " + location + " Tire 펑크 ***");
			return false;
		}
	}
}
