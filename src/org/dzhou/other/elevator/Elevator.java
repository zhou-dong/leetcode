package org.dzhou.other.elevator;

public interface Elevator {

	public boolean check();

	public boolean start();

	public boolean stop();

	public void register(Controller controller);

	public int getId();

	public int distance(int pickupFloor, int destFloor);

	public void addRequest(int pickupFloor, int destFloor);

	public Engine getEngine();

}
