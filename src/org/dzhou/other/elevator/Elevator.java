package org.dzhou.other.elevator;

public interface Elevator {

	public boolean preCheck();

	public boolean start();

	public boolean stop();

	public void register(Controller controller);

	public void unregister();

	public int getId();

	public int distance(int pickupFloor, int destFloor);

	public void addPickup(int pickupFloor, int destFloor);

}
