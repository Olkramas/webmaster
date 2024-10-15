package chap08.dataAccess241001;

public class OracleDao implements DataAccessObject {
	
	//인터페이스의 추상메소드 모두 재정의
	@Override
	public void delete() {
		System.out.println("Oracle DB에서 삭제");
		
	}
	@Override
	public void insert() {
		System.out.println("Oracle DB에서 삽입");
		
	}
	@Override
	public void select() {
		System.out.println("Oracle DB에서 검색");
		
	}
	@Override
	public void update() {
		System.out.println("Oracle DB에서 수정");
		
	}
}
