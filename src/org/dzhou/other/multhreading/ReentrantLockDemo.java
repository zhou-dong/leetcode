package org.dzhou.other.multhreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

	private int count = 0;
	private Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	private void increment() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public void firstThread() {
		lock.lock();
		// condition.await();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void secondThread() {
		lock.lock();
		try {
			increment();
		} finally {
			lock.unlock();
			// condition.signal();
		}
	}

	public void finished() {
		System.out.println(count);
	}

	public static void main(String[] args) {
		ReentrantLockDemo demo = new ReentrantLockDemo();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				demo.firstThread();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				demo.secondThread();
			}
		});
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		demo.finished();
	}
}
