package chap06;

public class MemberService {
	//필드
	String id;
	String password;
	
	//생성자
	MemberService() {}
	
	
	//메소드
	
	boolean login(String id, String password) {
		this.id = id;
		this.password = password;
		if(id.equals("hong") && password.equals("12345")) {
			return true;
		} else {
			return false;
		}
	}
	
	void logout(String id) {
		if(this.id.equals(id)) {
			System.out.println("로그아웃 되었습니다");
		} else {
			System.out.println("아이디를 잘못 입력하셨습니다.");
		}
	}
}
