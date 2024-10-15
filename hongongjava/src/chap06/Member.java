package chap06;

public class Member {
	//필드
	String name;
	String id;
	String password;
	int age;
	
	//기본생성자를 만들어줘야 member객체를 사용할 수 있음.
	Member() {}
	
	Member(String name, String id) {
		this.name = name;
		this.id = id;
	}
}
