package chap08.soundable241001;

public class SoundableExample {
	private static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}
	
	public static void main(String[] args) {
		printSound(new Cat());
		printSound(new Dog());
		
		Soundable sound = null;
		sound = new Dog();
		System.out.println(sound.sound());
		
		printSound(new Hourse());
		sound = new Hourse();
		System.out.println(sound.sound());

	}

}
