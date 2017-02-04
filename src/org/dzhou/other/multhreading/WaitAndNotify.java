package org.dzhou.other.multhreading;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WaitAndNotify {

	class Processor {
		List<Integer> list = new LinkedList<>();
		final int LIMIT = 10;
		private Object lock = new Object();

		public void produce() throws InterruptedException {
			int value = 0;
			while (true) {
				synchronized (lock) {
					while (list.size() == LIMIT) {
						lock.wait();
					}
					list.add(value++);
					lock.notify();
				}
			}
		}

		public void consume() throws InterruptedException {
			Random random = new Random();
			while (true) {
				synchronized (lock) {
					while (list.isEmpty()) {
						lock.wait();
					}
					int value = list.remove(0);
					System.out.println(value);
					lock.notify();
				}
				Thread.sleep(random.nextInt(1000));
			}
		}
	}

}
