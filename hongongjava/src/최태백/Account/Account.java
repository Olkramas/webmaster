package 최태백.Account;

public class Account {
	private String ano;
	private String owner;
	private int balence;
	public static final int MAX_BALANCE = 1000000;
	public static final int MIN_BALANCE = 0;
	private int count;
	
	
	public Account() {};
	public Account(String ano, String owner, int balence) {
		this.ano = ano;
		this.owner = owner;
		this.balence = balence;
	}
	
	//메소드
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	public void showList() {
		System.out.println("계좌번호: " + this.ano + "\t계좌 주: " + this.owner + "\t잔액: " + this.balence);
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getOwner() {
		return owner;
	} 
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalence() {
		return balence;
	}
	public void setBalence(int balence) {
		this.balence = balence;
	}
//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof Account) {
//			Account account = (Account) obj;
//			if(ano.equals(account.ano)) {
//				return true;
//			}
//		}
//		return false;
//	}
//	@Override
//	public int hashCode() {
//		return Integer.parseInt(ano);
//	}
}
