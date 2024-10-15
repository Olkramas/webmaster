package memo.singletonMemo.anotherExample;

public class ShopService {
	
	//싱글톤 객체 생성 (외부에서 접근 못함)
	private static ShopService service = new ShopService();
	//값을 저장할 필드 초기값이 설정돼있지 않음.
	private String shopName;
	
	//private 생성자
	private ShopService() {};
	
	//싱글톤 인스턴스를 얻기위한 메소드
	static ShopService getInstance() {
		return service;
	}
	
	
	//값이 null이면 입력된 매개변수 값을 저장하고 그 후로는 수정이 안됨.
	public void initialize(String shopName) {
		if(this.shopName == null) {
			this.shopName = shopName;
		} else {
			System.out.println("이미 초기화 된 객체입니다.");
		}
	}
	
	public String getShopName() {
		return shopName;
	}
	
	
}
