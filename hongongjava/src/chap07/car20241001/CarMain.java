package chap07.car20241001;

public class CarMain {

	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i=1; i<=5; i++) {
			int problemLocation = car.run();
			switch(problemLocation) {
				case 1:
					System.out.println("HankookTire로 교체합니다.");
					//재정의가 돼있다면 자식객체를 넣었을 때 다형성이 일어남
					car.frontLeftTire = new HankookTire("앞 왼쪽", 15);
					break;
				case 2:
					System.out.println("KunhoTire로 교체합니다.");
					car.frontRightTire = new KumhoTire("앞 오른쪽", 13);
					break;
				case 3:
					System.out.println("HankookTire로 교체합니다");
					car.backLeftTire = new HankookTire("뒤 왼족", 14);
					break;
				case 4:
					System.out.println("KumhoTire로 교체합니다");
					car.backRightTire = new KumhoTire("뒤 오른쪽", 17);
					break;
			}
			System.out.println("-----------------------------------------");
		}
		
		
	}

}
