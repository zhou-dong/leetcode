package org.dzhou.other.elevator;

public abstract class BaseElevator implements Elevator {

	protected int id;

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
		controller.addElevator(this);
	}

	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
