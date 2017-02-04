package org.dzhou.other.multhreading;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(2);
		semaphore.acquire();
		semaphore.acquire();
		semaphore.release();
		semaphore.acquire();
		System.out.println(semaphore.availablePermits());
	}

}
