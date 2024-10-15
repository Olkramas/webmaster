package chap07.page37720241001;

public class Main {
	public static void main(String[] args) {
		Controller controller = new Controller();
		
		
		controller.setService(new MemberService());
		controller.service.login();
		
		controller.setService(new AService());
		controller.service.login();
	}
}
