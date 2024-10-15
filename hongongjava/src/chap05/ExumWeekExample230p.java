package chap05;

import java.util.Calendar;

public class ExumWeekExample230p {

	public static void main(String[] args) {
		//날짜와 시간 얻기
		Calendar now = Calendar.getInstance();		//Calendar는 추상클래스라서 객체를 만들 수 없음. 메소드를 통해 결과를 리턴받아서 now가 가지게 됨.
		
		System.out.println(now);
		int year = now.get(Calendar.YEAR);	
		int month = now.get(Calendar.MONTH) + 1;	//month는 가져왔을때 원래 달에서 -1인 상태임. 그래서 +1을 더해줬음.
		int date = now.get(Calendar.DAY_OF_MONTH);	//DAY가 좀 다름.
		int day = now.get(Calendar.DAY_OF_WEEK);	//1-일요일 2-월요일... 7-토요일
		
		//enum을 변수로 하기위해서 enum타입(Week)으로 선언 상수들을 가져오게 됨.
		Week weekday = null;
		switch(day) {
			case 1: weekday = Week.일요일; break;
			case 2: weekday = Week.월요일; break;
			case 3: weekday = Week.화요일; break;
			case 4: weekday = Week.수요일; break;
			case 5: weekday = Week.목요일; break;
			case 6: weekday = Week.금요일; break;
			case 7: weekday = Week.토요일; break;
			default : System.out.println("오류");
		}
		
		System.out.printf("%d년 %d월 %d일 %s",year, month, date, weekday);
		
		
	}

}
