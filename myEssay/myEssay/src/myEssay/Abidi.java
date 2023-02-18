package myEssay;

public class Abidi implements Human{
	private Animal myEagle;
	public Abidi(Animal theEagle) {
		myEagle = theEagle;
	}
	
	@Override
	public void Own() {
		System.out.println("I own this eagle");
	}
}
