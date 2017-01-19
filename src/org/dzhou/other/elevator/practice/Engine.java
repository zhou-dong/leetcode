package org.dzhou.other.elevator.practice;

public interface Engine {

	public int distanceToPickup(int pickupFloor, int destFloor);

	public void addRequest(int pickupFloor, int destFloor);

}
