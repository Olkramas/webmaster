package chap06.singleton240930;

public class SingletonMain {
	public static void main(String[] args) {
		//싱글톤은 객체 생성 불가능함.
		//메소드를 통해서 받아야함.
		
		Singleton st1 = Singleton.getinstance();
		Singleton st2 = Singleton.getinstance();
		
		if(st1 == st2) {
			System.out.println("같은 객체");
		} else {
			System.out.println("다른 객체");
		}
 		
		st1.name = "아무개";
		System.out.println(st1.name);
		st1.name = "거시기";
		System.out.println(st2.name);
	}
}
