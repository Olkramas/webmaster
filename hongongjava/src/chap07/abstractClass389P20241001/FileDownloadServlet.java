package chap07.abstractClass389P20241001;

public class FileDownloadServlet extends HttpServlet{
	
	//추상메소드 재정의
	@Override
	public void service() {
		System.out.println("파일 다운로드 합니다.");
		
	}
	
	

}
