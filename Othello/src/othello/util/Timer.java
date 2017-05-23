package othello.util;

public class Timer {
	private long startTime;
	private long endTime;
	private float elapsedTime;
	
	public void startTimer() {
		startTime = System.currentTimeMillis();
	}
	
	public void stopTimer() {
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
	}
	
	public float getElapsedTime() {
		return elapsedTime / 1000;
	}
}
