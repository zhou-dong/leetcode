package org.dzhou.other.multhreading;

class RunnerThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread() + " " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class RunnerRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 11; i < 20; i++) {
			System.out.println(Thread.currentThread() + " " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Basic {
	public static void main(String[] args) {
		new RunnerThread().start();
		new RunnerThread().start();

		new Thread(new RunnerRunnable()).start();
		new Thread(new RunnerRunnable()).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("hello world...");
			}
		}).start();
	}
}
