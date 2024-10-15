package chap06;

public class Printer {
//	int num;
//	String str;
//	boolean tureOrNot;
//	double realNum;
	
	//println이라는 메소드를 오버로딩하기
	
	void println(int num) {
		System.out.println(num);
	}
	void println(boolean tureOrNot) {
		System.out.println(tureOrNot);
	}
	void println(double realNum) {
		System.out.println(realNum);
	}
	void println(String str) {
		System.out.println(str);
	}
	
}
