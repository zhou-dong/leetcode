package org.dzhou.other.multhreading;

import java.util.Scanner;

class Processor extends Thread {

	// volatile prevent thread caching this property
	private volatile boolean running = true;

	@Override
	public void run() {
		while (running) {
			System.out.println("hello world");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutDown() {
		running = false;
	}

}

public class ShutDown {

	public static void main(String[] args) {
		Processor proc = new Processor();
		proc.start();
		Scanner sanner = new Scanner(System.in);
		sanner.nextLine();
		proc.shutDown();
		sanner.close();
	}

}
