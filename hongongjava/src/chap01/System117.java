package chap01;

import java.io.IOException;

public class System117 {

	public static void main(String[] args) {
		int keyCode;
		
		while(true) {
			//예외 처리
			try {
				System.out.print("키를 입력하세요: ");
				keyCode = System.in.read();
				System.out.println("keyCode는 " + keyCode);
				if(keyCode == 113) {
					break;
				}
			} catch (IOException e) {	//IOException 처리
				System.out.println("입력오류 발생");
			}
			
		}
		System.out.println("종료");
		//위 코드는 문자열을 받아오지 못함. 그래서 필요한 Scanner객체
		
		
	}//end main

}//end class
