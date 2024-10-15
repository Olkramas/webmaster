package practice.chap02_06HomePractice;

public class PrintWeekEnum {

	public static void main(String[] args) {
		//열거타입
		Week today = Week.일요일;
		System.out.println(today);
		
		//정적필드 가져오기
		String today2 = StaticPractice.today;
		System.out.println(today2);
		
	}

}
