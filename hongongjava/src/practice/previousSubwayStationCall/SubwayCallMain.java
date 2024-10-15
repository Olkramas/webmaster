package practice.previousSubwayStationCall;

public class SubwayCallMain {

	public static void main(String[] args) {
		//기능: 지하철을 타고, 내가 탑승하는 역, 하차하는 역을 입력하면 다른데 집중하고 있어도 제때에 맞춰서 하차할 수 있음.
		//출발역 입력 - 도착역 입력 - 무슨역을 지나고 있는지 콘솔창에 출력하기(1초간격으로 출력) - 도착하면 사용자 휴대폰으로 알림
		
		SubwayCall callApp = new SubwayCall();
		callApp.menu();
	}

}