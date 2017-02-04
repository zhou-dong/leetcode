package org.dzhou.other.multhreading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockDemo {

	static class Account {
		private int balance = 100000;

		public void deposit(int amount) {
			balance += amount;
		}

		public void withdraw(int amount) {
			balance -= amount;
		}

		public int getBalance() {
			return balance;
		}

		public static void transfer(Account a1, Account a2, int amount) {
			a1.withdraw(amount);
			a2.deposit(amount);
		}
	}

	Account a1 = new Account();
	Account a2 = new Account();
	Lock lock1 = new ReentrantLock();
	Lock lock2 = new ReentrantLock();

	Random random = new Random();

	private void acquireLock(Lock lock1, Lock lock2) throws InterruptedException {
		while (true) {
			boolean gotFirstLock = false;
			boolean gotSecondLock = false;
			try {
				gotFirstLock = lock1.tryLock();
				gotSecondLock = lock2.tryLock();
			} finally {
				if (gotFirstLock && gotSecondLock) {
					return;
				}
				if (gotFirstLock) {
					lock1.unlock();
				}
				if (gotSecondLock) {
					lock2.unlock();
				}
			}
			Thread.sleep(1);
		}
	}

	public void firstThread() throws InterruptedException {
		for (int i = 0; i < 10000; i++) {
			acquireLock(lock1, lock2);
			try {
				Account.transfer(a1, a2, random.nextInt(10));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void secondThread() throws InterruptedException {
		for (int i = 0; i < 10000; i++) {
			acquireLock(lock2, lock1);
			try {
				Account.transfer(a2, a1, random.nextInt(10));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public static void main(String[] args) {
		DeadLockDemo demo = new DeadLockDemo();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					demo.firstThread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					demo.secondThread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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

		int b1 = demo.a1.getBalance();
		int b2 = demo.a2.getBalance();
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b1 + b2);
	}

}
