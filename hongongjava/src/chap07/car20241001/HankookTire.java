package chap07.car20241001;

public class HankookTire extends Tire {
	
	//생성자
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	//메소드
	@Override
	public boolean roll() {
		accRotation++;
		if(accRotation < maxRotation) {
			System.out.println(location + "Hankook Tire 수명: " + (maxRotation - accRotation) + "회 남음");
			return true;
		} else {
			System.out.println("***" + location + " HanKook Tire 펑크!!!" + "***");
			return false;
		}
	}
}
