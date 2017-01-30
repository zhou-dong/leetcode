package org.dzhou.other.designpattern;

public class SingletonPattern {

	public static class Singleton {
		private Singleton() {
		}

		private static Object locker = new Object();
		private static Singleton instance = null;

		public static Singleton getInstance() {
			if (instance == null) {
				synchronized (locker) {
					if (instance == null) {
						instance = new Singleton();
					}
				}
			}
			return instance;
		}
	}

	public static void main(String[] args) {
		boolean isEqual = Singleton.getInstance() == Singleton.getInstance();
		System.out.println(isEqual);
	}

}
