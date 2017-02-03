package org.dzhou.other.multhreading;

class BadExample {

	private int count = 0;

	class CountPlus implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 100000; i++) {
				count++;
			}
		}
	}

	void execute() {
		long begin = System.currentTimeMillis();
		Thread t1 = new Thread(new CountPlus());
		Thread t2 = new Thread(new CountPlus());
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(count + " duration: " + (System.currentTimeMillis() - begin));
	}

}

class SynchronizedExample {

	private int count = 0;

	public synchronized void increment() {
		count++;
	}

	class Processor implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 100000; i++) {
				increment();
			}
		}
	}

	void execute() {
		long begin = System.currentTimeMillis();
		Thread t1 = new Thread(new Processor());
		Thread t2 = new Thread(new Processor());
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(count + " durataion: " + (System.currentTimeMillis() - begin));
	}
}

public class SynchronizedDemo {

	public static void main(String[] args) {
		new BadExample().execute();
		new SynchronizedExample().execute();
	}

}
