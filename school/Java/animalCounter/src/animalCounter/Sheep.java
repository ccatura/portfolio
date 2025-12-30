package animalCounter;

public class Sheep extends Animal {
	
	public Sheep() {
		this.count = 0;
	}

	@Override
	public void incrementCount() {
		this.count += 2;
		System.out.println(this.count + " sheep.");
	}
	
	public void removeSheep() {
		if (this.count >= 1) {
			this.count -= 1;
			System.out.println("A sheep was eaten.");
		}
		
		System.out.println(this.count + " sheep.");

	}
}
