package org.dzhou.other.elevator;

import java.util.List;

public interface Controller {

	public void assignElevator(int pickupFloor, int destFloor);

	public boolean addElevator(Elevator elevator);

	public boolean removeElevator(int elevatorId);

	public boolean stopElevator(int elevatorId);

	public boolean startElevator(int elevatorId);

	public List<Elevator> getElevators();

}
