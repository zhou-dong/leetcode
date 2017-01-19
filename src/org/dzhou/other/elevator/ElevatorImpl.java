package org.dzhou.other.elevator;

import java.util.TreeSet;

public class ElevatorImpl implements Elevator {

	public enum Direction {
		UP, DOWN, IDLE;
	}

	// stand alone without controller
	public ElevatorImpl(int id) {
		this.id = id;
	}

	// add to the controller list
	public ElevatorImpl(int id, Controller controller) {
		this(id);
		controller.addElevator(this);
	}

	private int id;
	private int currFloor;
	private int destFloor;
	private Direction direction;

	TreeSet<Integer> stops = new TreeSet<>();

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public int distance(int pickupFloor, int destFloor) {
		if (pickupFloor == destFloor)
			return -1;
		if (this.direction == Direction.IDLE)
			return Math.abs(this.currFloor - pickupFloor);
		Direction requestDirection = calculateDirection(pickupFloor, destFloor);
		if (this.direction != requestDirection) {
			return differentDirectionDistance(pickupFloor);
		}
		if (calculateDirection(this.currFloor, pickupFloor) == requestDirection) {
			return Math.abs(this.currFloor - pickupFloor);
		} else {
			return differentDirectionDistance(pickupFloor);
		}
	}

	private Direction calculateDirection(int pickupFloor, int destFloor) {
		return pickupFloor > destFloor ? Direction.DOWN : Direction.UP;
	}

	private int differentDirectionDistance(int pickupFloor) {
		int stageOne = Math.abs(this.currFloor - this.destFloor);
		int stageTwo = Math.abs(this.destFloor - pickupFloor);
		return stageOne + stageTwo;
	}

}
