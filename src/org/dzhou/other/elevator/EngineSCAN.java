package org.dzhou.other.elevator;

import java.util.TreeSet;

import org.dzhou.other.elevator.ElevatorImpl.Direction;

public class EngineSCAN implements Engine, Runnable {

	TreeSet<Integer> upStops = new TreeSet<>();
	TreeSet<Integer> downStops = new TreeSet<>();

	private Direction currDirection;

	private Thread thread;
	private int currFloor;
	private int highestFloor;
	private int lowestFloor;

	EngineSCAN(int highestFloor, int lowestFloor) {
		this.highestFloor = highestFloor;
		this.lowestFloor = lowestFloor;
	}

	@Override
	public int distance(int pickupFloor, int destFloor) {
		if (pickupFloor == destFloor)
			return -1;
		if (this.currDirection == Direction.IDLE)
			return Math.abs(pickupFloor - currFloor);

		Direction requestDirection = Direction.getDirection(pickupFloor, destFloor);
		Direction currToPickupDirection = Direction.getDirection(currFloor, pickupFloor);

		if (currDirection != requestDirection) {
			return Math.abs(currFloor - getDestFloor()) + Math.abs(getDestFloor() - pickupFloor);
		}
		// All in same direction
		if (currDirection == currToPickupDirection) {
			return Math.abs(currFloor - pickupFloor);
		}
		int distance = Math.abs(currFloor - getDestFloor());
		distance += Math.abs(getHighestFloor() - getLowestFloor());
		if (currDirection == Direction.UP) {
			return distance + Math.abs(pickupFloor - getLowestFloor());
		} else {
			return distance + Math.abs(getHighestFloor() - pickupFloor);
		}
	}

	public int getDestFloor() {
		return this.currDirection == Direction.UP ? getHighestFloor() : getLowestFloor();
	}

	public int getHighestFloor() {
		return this.highestFloor;
	}

	public int getLowestFloor() {
		return this.lowestFloor;
	}

	@Override
	public void addRequest(int pickupFloor, int destFloor) {
		Direction direction = Direction.getDirection(pickupFloor, destFloor);
		if (direction == null)
			return;
		if (direction == Direction.UP) {
			addStops(upStops, pickupFloor, destFloor);
		} else {
			addStops(downStops, pickupFloor, destFloor);
		}
	}

	private void addStops(TreeSet<Integer> stops, int pickupFloor, int destFloor) {
		stops.add(pickupFloor);
		stops.add(destFloor);
	}

	@Override
	public void run() {
		while (!this.isEmpty()) {
			if (this.currDirection == Direction.UP) {
				goUp();
			}
			if (this.currDirection == Direction.DOWN) {
				goDown();
			}
		}
		this.currDirection = Direction.IDLE;
	}

	private boolean isEmpty() {
		return this.upStops.isEmpty() && this.downStops.isEmpty();
	}

	private void goUp() {
		while (currFloor != getHighestFloor()) {
			int nextFloor = upStops.higher(currFloor);
			arriveFloor(upStops, currFloor, nextFloor);
			currFloor = nextFloor;
		}
		this.currDirection = Direction.DOWN;
	}

	private void goDown() {
		while (currFloor != getLowestFloor()) {
			int nextFloor = upStops.lower(currFloor);
			arriveFloor(upStops, currFloor, nextFloor);
			currFloor = nextFloor;
		}
		this.currDirection = Direction.UP;
	}

	private void arriveFloor(TreeSet<Integer> stops, int prev, int curr) {
		stops.remove(prev);
	}

	@Override
	public boolean start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
		return true;
	}

	@Override
	public boolean stop() {
		if (thread != null) {
			thread.interrupt();
		}
		return true;
	}

}
