package org.dzhou.other.elevator;

import java.util.List;

public interface Controller {

	public Elevator assignElevator(int pickupFloor, int destFloor);

	public boolean addElevator(Elevator elevator);

	public boolean removeElevator(int elevatorId);

	public List<Elevator> getElevators();

}
