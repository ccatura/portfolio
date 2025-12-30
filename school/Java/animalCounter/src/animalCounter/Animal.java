package animalCounter;

public abstract class Animal implements Countable {
    protected int count;

    public void resetCount() {
    	this.count = 0;
    }

    public int getCount() {
    	return this.count;
    }
    
//    public abstract void incrementCount();
}
