package com.csueb.DiningPhilosoper;

public class Philosophers implements Runnable {
	private Object lFork;
	private Object rFork;

	public Philosophers(Object lFork, Object rFork) {
		this.lFork = lFork;
		this.rFork = rFork;
	}

	private void actionToBePerformed(String action) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + action);
		Thread.sleep(((int) (Math.random() * 100)));
	}

	@Override
	public void run() {
		try {
			while (true) {
				actionToBePerformed(": Thinking");
				synchronized (lFork) {
					actionToBePerformed(": Picked up left fork");
					synchronized (rFork) {
						actionToBePerformed(": Picked up right fork, eating");

						actionToBePerformed(": Put down right fork");
					}
					actionToBePerformed(": Put down left fork, thinking");
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return;
		}
	}
}