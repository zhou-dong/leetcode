package org.dzhou.other.elevator;

public interface Engine {

	public int distance(int pickupFloor, int destFloor);

	public void addRequest(int pickupFloor, int destFloor);
}
