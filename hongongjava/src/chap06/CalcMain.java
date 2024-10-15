package chap06;

public class CalcMain {

	public static void main(String[] args) {
		//객체 생성하기
		Calculator myCalc = new Calculator();
		
		//정사각형 넓이 구하기
		double result1 = myCalc.areaRectangle(10);
		
		//직사각형 넓이 구하기
		double result2 = myCalc.areaRectangle(10, 20);
		
		//출력
		System.out.println("정사각형 넓이: " + result1);
		System.out.println("직사각형 넓이: " + result2);
		
		//원 넓이 구하기
		double result3 = myCalc.circle(10);
		System.out.println("원의 넓이: " + result3);
	}

}
