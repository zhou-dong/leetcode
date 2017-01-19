package org.dzhou.other.elevator;

public abstract class BaseElevator implements Elevator {

	@Override
	public boolean start() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean stop() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void register(Controller controller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unregister() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int distance(int pickupFloor, int destFloor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addPickup(int pickupFloor, int destFloor) {
		// TODO Auto-generated method stub

	}

}
