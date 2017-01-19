package org.dzhou.other.elevator;

public class ElevatorImpl extends BaseElevator {

	public enum Direction {
		UP, DOWN, IDLE;

		public static Direction getDirection(int from, int to) {
			return from == to ? null : from > to ? DOWN : UP;
		}
	}

	private Engine engine;
	private boolean isAvailable;

	@Override
	public int distance(int pickupFloor, int destFloor) {
		return engine.distance(pickupFloor, destFloor);
	}

	@Override
	public void addRequest(int pickupFloor, int destFloor) {
		engine.addRequest(pickupFloor, destFloor);
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

	@Override
	public Engine getEngine() {
		return this.engine;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
}
