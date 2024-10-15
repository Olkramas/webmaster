package chap07.page37720241001;

class Controller {
	
	public MemberService service;
	
	public void setService(MemberService service) {
		this.service = service;
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		
		
		controller.setService(new MemberService());
		controller.service.login();
		
		controller.setService(new AService());
		controller.service.login();
	}
}	
