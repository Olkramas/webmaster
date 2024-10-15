package chap05;

public class LoginResultExample {

	public static void main(String[] args) {
		
		LoginResult result = LoginResult.FAIL_PASSWORD;
		
		if(result == LoginResult.SUCCESS) {
			System.out.println("로그인에 성공하셨습니다.");
		} else if(result == LoginResult.FAIL_ID) {
			System.out.println("아이디가 틀렸습니다.");
		} else if(result == LoginResult.FAIL_PASSWORD) {
			System.out.println("비밀번호가 틀렸습니다.");
		} else {
			System.out.println("오류입니다. \n 프로그램을 다시 실행하세요.");
		}
	}
	

}
