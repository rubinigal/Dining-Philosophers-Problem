import java.util.Random;

public class Philosopher extends Thread {
	private int id;
	private boolean isEating;
	private static Random r = new Random();
	private final int MAX_TIME = 5; // How long you want the philosophers to wait in seconds
	private Sticks sticks;
	
	public Philosopher(int id, Sticks sticks) {
		this.id = id;
		this.sticks = sticks;
		isEating = false;
	}
	
	public void run() {
		super.run();
		while (true) {
			if (!isEating) 
				eat();			
			else 
				think();	
		}
	}
	
	private void eat() {
		sticks.takeSticks(id);
		isEating = true;
		PhilosopherProblemController.updateEating(id);
		waitSomeTime();
	}
	
	private void think() {
		sticks.releaseSticks(id);
		isEating = false;
		PhilosopherProblemController.updateThinking(id);
		waitSomeTime();
	}
	
	private void waitSomeTime() {
		try {
			sleep((r.nextInt(MAX_TIME) + 1)*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
