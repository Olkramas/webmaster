package chap06;

public class MemberMain {

	public static void main(String[] args) {
		Member member = new Member();
		Member member2 = new Member("홍길동", "hong");
		
		System.out.println("이름: " + member.name);
		System.out.println("나이: " + member.age);
		
		member.name = "최하얀";
		member.age = 23;
		
		System.out.println("이름: " + member.name);
		System.out.println("나이: " + member.age);
		
		System.out.println();
		System.out.println("이름: " + member2.name);
		System.out.println("id: " + member2.id);
		
	}

}
