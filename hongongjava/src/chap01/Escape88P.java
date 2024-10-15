package chap01;

public class Escape88P {

	public static void main(String[] args) {
		
		//이스케이프 문자 사용법
		System.out.println("번호\t이름\t직업");
		System.out.print("행 단위 출력\n");
		System.out.print("행 단위 출력\n");
		System.out.println("우리는 \"개발자\" 입니다");
		System.out.println("봄\\여름\\가을\\겨울");
		
		//91p. 스탑이 true 인 경우에 else 의 경우로 출력하게 만들기
		
		boolean stop = true;
		
		//시작합니다를 출력하기 위해서는 stop 이 참이 아닐경우 중지합니다 출력.
		if(!stop) {
			System.out.println("중지합니다");
		} else {
			System.out.println("시작합니다");
		}
		
		//정수연산은 모두 int로 바뀜, 실수연산은 모두 double로 바뀜
		
		//103p. 타입변환
		byte byteValue1 = 10;
		byte byteValue2 = 20;
		//byte byteValue3 = byteValue1 + byteValue2; int로 연산하는데 변수의 타입이 byte라서 안됨.
		int intValue1 = byteValue1 + byteValue2;
		System.out.println(intValue1);
		
		char charValue1 = 'A';
		char charValue2 = 1;
		//char charValue3 = charValue1 + charValue2;
		int intValue2 = charValue1 + charValue2;
		System.out.println("유니코드=" + intValue2);
		System.out.println("출력문자=" + (char)intValue2);
		
		int intValue3 = 10;
		int intValue4 = intValue3 / 4;
		System.out.println(intValue4);
		
		int intValue5 = 10;
		//int intValue6 = 10 /4.0;
		double doubleValue = intValue5 / 4.0;
		System.out.println(doubleValue);
		
		int x = 1;
		int y = 2;
		double result = (double) x / y;
		System.out.println(result);
		
		//106p. 문자열을 숫자로 변환시키고, 숫자를 문자열로 변환 시키기
		int value1 = Integer.parseInt("10");
		double value2 = Double.parseDouble("3.14");
		boolean value3 = Boolean.parseBoolean("true");
		
		System.out.println("value1: " + (value1 + 100));	//숫자를 먼저 연산하기 위해서 ()사용.
		System.out.println("value2: " + (value2 + 100));
		System.out.println("value3: " + value3);
		
		//숫자를 문자로 바꿈.
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(3.14);
		String str3 = String.valueOf(true);
		
		System.out.println("str1: " + (str1 + 100));
		System.out.println("str2: " + (str2 + 100));
		System.out.println("str3: " + str3);
		
		
		//109p. 강제 타입변환
		char c1 ='a';
		char c2 = (char)(c1 + 1);	// 연산한 모든 식을 (char)으로 강제타입변환하기. 
		int c3 = c1 + 1;	//연산한 결과를 int로 저장해서 코드값을 출력하기 위한 변수.
		
		System.out.println(c2);
		System.out.println((int)c2);
		System.out.println(c3);
		
		//6
		int x1 = 5;
		int y1 = 2;
		int result1 = x1 / y1;
		System.out.println(result1);
		//결과는 2가 나옴. 정수를 정수로 나눠서 int타입에 저장을 했으니까 소수점 아래는 저장을 안함.
		
		//7
		int x2 = 5;
		int y2 = 2;
		double result2 = (double)x2 / y2;	//x2를 double로 강제 타입 변환 하면서 double값으로 저장할 수 있음.
		System.out.println(result2);
		
		//8
		double var1 = 3.5;
		double var2 = 2.7;
		int result3 = (int)(var1 + var2);	//계산된 결과를 int로 강제 타입변환해서 정수부분만 출력될 수 있게 만들었음.
		System.out.println(result3);
		
		//9
		long var3 = 2l;
		float var4 = 1.8f;
		double var5 = 2.5;
		String var6 = "3.9";
		int result4 = (int)(var3 + var4 + (int)(var5 + Double.parseDouble(var6)));
		System.out.println("9번 정답은 " + result4);
		System.out.println(var3 + var4);
		
		
		//10
		String str4 = 2 + 3 + "";
		String str5 = 2 + "" + 3;
		String str6 = "" + 2 + 3;
		System.out.println(str4);
		System.out.println(str5);
		System.out.println(str6);
				
		//11
		byte value4 = Byte.parseByte("10");
		int value5 = Integer.parseInt("1000");
		float value6 = Float.parseFloat("20.5");
		double value7 = Double.parseDouble("3.14159");
		
		
	}//end main

}//end class
