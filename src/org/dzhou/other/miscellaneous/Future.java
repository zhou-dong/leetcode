package org.dzhou.other.miscellaneous;

public class Future {

	// An abstration to hold a value that will be available in the future.

	private int value;
	private volatile boolean isReady = false;
	private Object lock = new Object();

	// Get the value of this future. This method will block if the value is
	// not ready.
	public int get() {
		if (isReady) {
			return this.value;
		}
		synchronized (lock) {
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return this.value;
	}

	// Make the value ready.
	public void set(int value) {
		this.value = value;
		this.isReady = true;
		synchronized (lock) {
			lock.notify();
		}
	}

}
