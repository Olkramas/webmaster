package memo.delay;

public class DelayPractice {
	
	
	//메소드
	void run() {
		int count = 0;
		while(true) {			
			try {
				Thread.sleep(800);
				System.out.println("delay실험");
				count++;
				if(count > 4) {
					break;
				}
			} catch(InterruptedException e) {
				System.out.println("오류발생");
			}
		}
	}

}
