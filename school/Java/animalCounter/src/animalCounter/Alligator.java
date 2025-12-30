package animalCounter;

public class Alligator extends Animal {
	
	public Alligator() {
		this.count = 0;
	}
	
	@Override
	public void incrementCount() {
		this.count ++;
		System.out.println(this.count + " alligators.");
	}

	public void eatSheep() {
		
	}
	
}
