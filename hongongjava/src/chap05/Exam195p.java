package chap05;

public class Exam195p {

	public static void main(String[] args) {
		//참조타입의 번지 비교(==)
		//데이터(문자열)을 비교(.equals)
		
		String strVar1 = "신민철";
		String strVar2 = "신민철";
		
		if(strVar1 == strVar2) {
			System.out.println("strVar1 과 strVar2는 참조가 같다");		//출력됨.
		} else {
			System.out.println("strVar1 과 strVar2는 참조가 다르다");
		}
		
		if(strVar1.equals(strVar2)) {
			System.out.println("strVar1 과 strVar2는 문자열이 같다");		//출력됨.
		}
		
		String strVar3 = new String("신용권");
		String strVar4 = new String("신용권");
		
		if(strVar3 == strVar4) {
			System.out.println("strVar3 과 strVar4는 참조가 같다");
		} else {
			System.out.println("strVar3 과 strVar4는 참조가 다르다");		//출력됨
		}
		
		if(strVar3.equals(strVar4)) {
			System.out.println("strVar3 과 strVar4는 문자열이 같다");		//출력됨.
		}
		
		String var1 = "AB";
		String var2 = new String("AB");
		
		if(var1.equals(var2)) {
			System.out.println("var1과 var2는 문자열이 같다.");
		}
	}

}
