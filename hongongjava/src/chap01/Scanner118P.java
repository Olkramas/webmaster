package chap01;

import java.util.Scanner;

public class Scanner118P {

	public static void main(String[] args) {
		//미리 만들어져있는 클래스를 사용하기 위해서는 import를 시켜서 사용할 수 있음.
		Scanner sc = new Scanner(System.in);	//System.in의 의미는 표준 입력장치로 사용하겠다. 라는 의미. (키보드 사용하겠다는 말)
		String str;
		
		
		//문자열 받기
		System.out.print("문자열 입력 > ");
		str = sc.nextLine();
		System.out.println("입력받은 문자열은 " + str);
		
		//sc는 Scanner의 객체변수임. 그래서 sc에는 주소값을 참조하고 있기때문에 ==으로는 비교가 안됨.
		if(str == "q") {
			System.out.println("q입력됨");
		} else {
			System.out.println("같지 않음");
		}
		
		//객체에 저장된 값을 비교하기 위해서는 .equals()메소드를 사용해야 함. 교재 118p
		if(str.equals("q")) {
			System.out.println("q입력됨");
		} else {
			System.out.println("같지않음");
		}
		
		//정수 받기
		int num;
		
		System.out.println("정수 입력 > ");
		num = sc.nextInt();
		System.out.println("입력하신 정수는 " + num);
		str = sc.nextLine();	//nextInt로 가져오면 공백이 생기는데, 그 공백을 여기 nextLine이 가져오기 때문에 문제가 생길 수 있음. 이걸로 공백을 한번 치우고 아래에서 nextLine()사용하면 됨.
		
		//문자열을 받아서 정수로 변환하면 위같은 방식은 사용안해도 됨.
		System.out.print("숫자 입력 > ");
		int valInt = Integer.parseInt(sc.nextLine());						
		System.out.println("입력받은 숫자 + 100 : " + (valInt + 100));

		
		sc.close(); //sc를 사용하고 .close()로 닫아주면 사용을 마침. close후 스캐너 객체를 사용할 수 없음 그래야 sc의 노란색 줄이 사라짐.
		//스트림을 정상적으로 닫기 위해서 .close()를 사용함.
	}

}
