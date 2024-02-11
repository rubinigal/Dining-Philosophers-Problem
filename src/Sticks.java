import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sticks {
	private final int SIZE = 5;
	private Lock sticks[];
	
	public Sticks() {
		sticks = new Lock[SIZE];
		for (int i = 0; i < SIZE; i++) {
			sticks[i] = new ReentrantLock();
		}
	}
	
	public void takeSticks(int index) { // We fix the deadlock problem by preventing a circle
		int smaller, bigger;
		// We numbered the sticks and we try to take the one with the smallest index.
		// The last Philosopher (number 5), rather then taking stick number 4 will take number 0,
		// And this breaks the circle.
		if (index-1 < index%SIZE) { 
			smaller = index-1;
			bigger = index%SIZE;
		}
		else {
			smaller = index%SIZE;
			bigger = index - 1;
		}
		// We are waiting for both sticks
		sticks[smaller].lock();
		sticks[bigger].lock();
	}
	
	public void releaseSticks(int index) {
		sticks[index-1].unlock();
		sticks[index%SIZE].unlock();
	}
}
