package practice.chap02_06HomePractice;

public class IntegerLiteralExampleP83 {

	public static void main(String[] args) {
		int var1 = 0b1011;		//2진법으로 표기함.
		int var2 = 0206;		//8진수
		int var3 = 365;			//10진수
		int var4 = 0xB3;		//16진수
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
		
		byte bt1 = 123;
		//byte bt2 = 128;		//byte의 범위를 초과해서 컴파일 에러
		
		int intval1 = Integer.MAX_VALUE;	//정수타입의 가장 큰 값을 가져옴.
		int intval2 = Integer.MIN_VALUE;	//정수타입의 가장 작은 값을 가져옴.
		System.out.println("int의 최댓값: " + intval1 + " int의 최소값: " + intval2);
		
		double douVal = Double.MAX_VALUE;
		System.out.println(douVal);
		
		long longVal = Long.MAX_VALUE;
		System.out.println(longVal );
	}

}
