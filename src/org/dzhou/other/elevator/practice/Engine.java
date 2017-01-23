package org.dzhou.other.elevator.practice;

import org.dzhou.other.elevator.ElevatorImpl.Direction;

public interface Engine {

	public class Status {
		Direction direction;
		int currFloor;
		int nextFloor;
		int destFloor;
	}

	public int distanceToPickup(int pickupFloor, int destFloor);

	public void addRequest(int pickupFloor, int destFloor);

	public Status arrivedFloor();

}
