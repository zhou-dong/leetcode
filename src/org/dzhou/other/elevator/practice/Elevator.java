package org.dzhou.other.elevator.practice;

public class Elevator implements Engine {

	private int id;
	private Engine engine;

	public boolean start() {

		return true;
	}

	public boolean stop() {
		return true;
	}

	public Elevator(int id, Engine engine) {
		this.id = id;
		this.engine = engine;
	}

	@Override
	public int distanceToPickup(int pickupFloor, int destFloor) {
		return engine.distanceToPickup(pickupFloor, destFloor);
	}

	@Override
	public void addRequest(int pickupFloor, int destFloor) {
		engine.addRequest(pickupFloor, destFloor);
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public Status arrivedFloor() {
		// TODO Auto-generated method stub
		return null;
	}

}
