package chap06.makeSingleton307p240930;

public class ShopService {
	//싱글톤 기법 사용
	//필드 -> 자신의 객체 저장
	//생성자 -> 외부 접근을 막아야 함.
	//메소드 -> 외부로 객체를 전달할 수 있는 메소드를 만들어야 함.
	
	//하나의 인스턴스만을 유지하기 위한 필드 (외부에서 값을 바꿀 수 없음)
	private static ShopService service = new ShopService();
	
	private ShopService() {};
	
	//클래스로 메소드에 접근하게 하기 위해서 정적메소드로 선언 = static
	static ShopService getInstance() {
		return service;
	}
	
	
}
