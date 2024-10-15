package chap07.abstractClass389P20241001;

public class LoginServlet extends HttpServlet{
	
	//추상메소드 재정의
	@Override
	public void service() {
		System.out.println("로그인 합니다.");
		
	}

}
