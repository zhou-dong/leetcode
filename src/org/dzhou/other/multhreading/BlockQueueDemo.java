package org.dzhou.other.multhreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueueDemo {

	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

	public void push(int value) {
		queue.add(value);
	}

	public int get() {
		try {
			return queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return -1;
		}
	}

}
