package memo.singletonMemo.basicOfSingleton;

public class ShopServiceMain {

	public static void main(String[] args) {
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();
		
		if(obj1 == obj2) {
			System.out.println("같은 객체를 참조합니다.");
		}
		

	}

}
