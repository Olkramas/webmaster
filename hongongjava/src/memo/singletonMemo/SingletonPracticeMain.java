package memo.singletonMemo;

public class SingletonPracticeMain {

	public static void main(String[] args) {
		Singleton st1 = Singleton.getInstance();
		Singleton st2 = Singleton.getInstance();
		
		//위치 정보 출력
		System.out.println(st1);
		
		if(st1 == st2) {
			System.out.println("같은 주소를 참조하고 있습니다.");
		} else {
			System.out.println("다릅니다.");
		}
		
		
	}

}
