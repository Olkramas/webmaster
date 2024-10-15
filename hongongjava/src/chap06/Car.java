package chap06;

public class Car {
	//필드
	String company = "현대자동차";
	String model = "그랜저";
	String color = "검정";
	private int maxSpeed = 300;
	private int speed;
	private int gas;
	private boolean gasState;
	//boolean은 기본값이 false임.
	private boolean stop;
	
	
	//생성자
	
	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		speed = 0;
		this.stop = stop;
	}

	//메소드
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		if(speed < 0) {
			this.speed = 0;
			return;		//메소드 종료
		} 
		this.speed = speed;
	}
	
	public int getGas() {
		return gas;
	}
	
	public void setGas(int gas) {
		this.gas = gas;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	//boolean 타입일 때 get은 is를 붙이는게 관례임.
	public boolean isGasState() {
		return gasState;
	}

	public void setGasState(boolean gasState) {
		this.gasState = gasState;
	}

	//gas가 있는지 없는지 확인하는 메소드
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("gas가 없습니다.");
			return false;
		}
		System.out.println("gas가 있습니다.");
		return true;
	}
	

	void run() {
		while(true) {
			if(gas > 0) {
				System.out.println("달립니다 (gas잔량: " + gas + ")");
				gas--;
			} else {
				System.out.println("멈춥니다 (gas잔량: " + gas + ")");
				//void일 때 return은 메소드 자체를 종료 시킬 수 있음.
				return;
			}
		}
	}
	
	void keyTurnOn() {
		System.out.println("키를 돌립니다.");
	}
	
	void run2() {
		for(int i=10; i<= 50; i+=10) {
			speed = i;
			System.out.println("달립니다. (시속:" + speed + "km/h)");
		}
	}
	
	
}
