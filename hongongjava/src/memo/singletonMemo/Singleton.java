package memo.singletonMemo;

public class Singleton {
	private static Singleton single = new Singleton();
	String name = "최태백";
	
	private Singleton() {};
	
	static Singleton getInstance() {
		return single;
	}
}
