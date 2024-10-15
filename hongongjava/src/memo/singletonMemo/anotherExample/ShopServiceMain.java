package memo.singletonMemo.anotherExample;

public class ShopServiceMain {

	public static void main(String[] args) {

		ShopService service = ShopService.getInstance();
		
		service.initialize("qkqqkq");
		System.out.println(service.getShopName());
		service.initialize("1231sqa");
		System.out.println(service.getShopName());
		
	}

}
