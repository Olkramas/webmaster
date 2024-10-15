package chap03;

public class Exam150 {

	public static void main(String[] args) {
		//4. 
		int pencils = 534;
		int students = 30;
		
		int pencilsPerStudent = pencils / students;
		System.out.println("일인당 연필 개수 " + pencilsPerStudent + "개");
		
		int pencilsLeft = pencils % students;
		System.out.println("남은 연필 개수 " + pencilsLeft + "개");
	}

}
