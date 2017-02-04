package org.dzhou.other.multhreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuture {

	static class Processor implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			System.out.print(Thread.currentThread().getName());
			return new Random().nextInt(100);
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			Future<Integer> future = executor.submit(new Processor());
			System.out.println(" " + future.get());
		}
		executor.shutdown();
	}

}
