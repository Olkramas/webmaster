package practice.previousSubwayStationCall;

import java.util.Scanner;

public class SubwayCall {
	//필드
	String[] station = {"문양", "다사", "대실", "강창", "계명대", "성서산업단지", 
						"이곡", "용산", "죽전", "감삼", "두류", "내당", "반고개", 
						"청라언덕", "반월당", "경대병원", "대구은행", "범어", "수성구청",
						"만촌", "담티", "연호", "대공원", "고산", "신매", "사월", 
						"정평", "임당", "영남대"};
	String startStation = null;
	String destination = null;
	
	//생성자
	
	
	//메소드
	Scanner scanner = new Scanner(System.in);
	
	//메뉴 출력 메소드. 입력 / 종료 두가지 기능을 가지고 있음.
	void menu() {
		boolean stopMenu = true;
		while(stopMenu) {
			int startNum = 0;
			int destiNum = 0;
			
			System.out.println("----------------------------");
			System.out.println("     **메뉴를 선택해주세요.**");
			System.out.println("  1.출발/도착역 입력하기\n  2.대구 지하철 2호선 노선도 보기\n  3.종료");
			System.out.println("-----------------------------");
			int firstMenu = Integer.parseInt(scanner.nextLine());
			
			//swith로 바꿔서 1=출발역, 2= 대구지하철 2호선 노선도 보기 3= 종료
			
			switch(firstMenu) {
				case 1: 
					System.out.print("출발역을 입력해주세요(\"역\"빼고 입력) > ");
					this.startStation = scanner.nextLine();
					System.out.print("도착역을 입력해주세요(\"역\"빼고 입력) > ");
					this.destination = scanner.nextLine();
					
					
					//*******************연산자 착각했음.**************************
					//문자열 비교할때 무조건 .equals사용하기. ==으로 비교하면 주소만 비교함.
					//문자열비교? 무조건 .equals알겠냐????
					for(int i=0; i<this.station.length; i++) {
						if(this.station[i].equals(this.startStation)) {
							startNum = i;
						}
					}
					for(int i=0; i<this.station.length; i++) {
						if(this.station[i].equals(this.destination)) {
							destiNum = i;
						}
					}
					
					System.out.println("\n" + this.startStation + "에서 출발합니다.");
					System.out.println("도착역 전 역에서 알림을 드리겠습니다.\n");
					System.out.println("------------------------");
					run(startNum, destiNum);
					return;
				case 2:
					showSation();
					break;
				case 3:
					System.out.println("이용해주셔서 감사합니다\n프로그램을 종료합니다.");
					return;
				default: 
					System.out.println("잘못된 선택입니다 \n메뉴로 돌아갑니다. \n");
					
			}
		}
	}
	
	
	//열차가 출발하고 출발역-도착역 도착할 때 까지 어디역이라고 메시지를 계속 보내야 함.
	
	//매개변수로 출발역, 도착역의 인덱스 번호를 받았음.
	void run(int startStation, int destination) {
		int count = 0;
		boolean runForStop = true;
		while(runForStop) {
			//만약 출발역의 인덱스 번호가 도착역의 인덱스 번호보다 크다면, 문양행 작다면 영대행, 같을경우 오류 다시시작하기
			
			//문양행
			if(startStation > destination) {

				for(int i=startStation; i>destination+1; i--) {
					int random = (int) (Math.random()* 1000 + 501);
					count++;
					try {
						Thread.sleep(random);
						System.out.println("\n  ==이번역은 " + this.station[i-1] + "역 입니다==");
						System.out.println("   도착까지 남은 역 수: " + (startStation - destination - count));
						System.out.println("\n------------------------");
					} catch (InterruptedException e) {
						System.out.println("오류가 발생했습니다. \n고객센터에 문의 바랍니다.");
					}
				}
				notice();
				runForStop = false;
			//영대행
			} else if(startStation < destination) {
				for(int i=startStation; i<destination-1; i++) {
					count++;
					try {
						Thread.sleep(1000);
						System.out.println("\n  ==이번역은 " + this.station[i+1] + "역 입니다==");
						System.out.println("   도착까지 남은 역 수: " + (destination - startStation - count));
						System.out.println("\n------------------------");
					} catch (InterruptedException e) {
						System.out.println("오류가 발생했습니다. \n고객센터에 문의 바랍니다.");
					}
				}
				notice();
				runForStop = false;
			} else {
				System.out.println("잘못된 입력입니다 \n프로그램을 다시 시작합니다.");
				runForStop = false;
				menu();
			}
		}
	}
	
	void notice() {
		try {
			Thread.sleep(1000);
			System.out.println("\n*************************");
			System.out.println(" 다음은 도착역인 \"" + this.destination + "\"역 입니다\n"); 
			System.out.println(" 내릴실 때 차안에 두고내리는\n 물건이 없는지 다시 한번 확인하세요\n");
			System.out.println(" 서비스를 이용해주셔서 감사합니다 \n 프로그램을 종료합니다.");
			System.out.println("*************************\n");
		} catch(InterruptedException e) {
			System.out.println("오류가 발생했습니다. \n고객센터에 문의 바랍니다.");
		}
	}
	
	void showSation() {
		
		System.out.println("=====대구 지하철 2호선 노선도=====\n");
		//향상된 for문 사용. 환승가능역에서 *을 찍고 싶어서 이거는 안쓰고 다시 만들예정
		/*
		for(String ele : this.station) {
			System.out.println("\t   " + ele + " \n");
		}
		*/
		
		for(int i=0; i<this.station.length; i++) {
			if(this.station[i] == "반월당" || this.station[i] == "청라언덕") {
				System.out.print("\t * ");
			} else {
				System.out.print("\t   ");
			}
			System.out.println(this.station[i] + "\n");
		}
		System.out.println("===========================");
		System.out.println("* : 환승역 표시\n\n");
		menu();
	}
}
