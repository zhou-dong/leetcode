package org.dzhou.other.elevator;

import java.util.TreeSet;

public class ElevatorImpl extends BaseElevator {

	public enum Direction {
		UP, DOWN, IDLE;
	}

	private int currFloor;
	private int destFloor;
	private Direction direction;
	private boolean isAvailable;

	TreeSet<Integer> stops = new TreeSet<>();

	@Override
	public int distance(int pickupFloor, int destFloor) {
		if (isAvailable == false || pickupFloor == destFloor)
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

	@Override
	public void addPickup(int pickupFloor, int destFloor) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean start() {
		isAvailable = true;
		return true;
	}

	@Override
	public boolean stop() {
		isAvailable = false;
		return true;
	}

	@Override
	public boolean check() {
		return false;
	}

}
