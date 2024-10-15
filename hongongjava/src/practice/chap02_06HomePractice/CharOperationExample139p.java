package practice.chap02_06HomePractice;

public class CharOperationExample139p {

	public static void main(String[] args) {
		char c1 = 'A' + 1;
		char c2 = 'A';
		char c3 = (char)(c2 + 1);
		
		
		//char타입으로 선언한 c3	는 c2와 1(int)이 연산이 되기 때문에 int로 선언해야함. 
		//더 큰범위의 값이 아래 범위의 값에 들어가려면 강제 타입변환을 꼭 해야함.
		//char c3 = c2 + 1;
		
		System.out.println("c1: " + c1);
		System.out.println("c3: " + c3);
		
	}

}
