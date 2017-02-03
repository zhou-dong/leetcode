package org.dzhou.other.multhreading;

import java.util.concurrent.CountDownLatch;

public class CountDown {

	static class Processor implements Runnable {
		CountDownLatch latch;

		public Processor(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			latch.countDown();
			System.out.println("processor finished");
		}
	}

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		for (int i = 0; i < 3; i++) {
			new Thread(new Processor(latch)).start();
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("programming finished");
	}

}
