package org.dzhou.other.elevator.practice;

import java.util.List;

import org.dzhou.other.elevator.practice.Elevator;

public interface Controller {

	public void assignElevator(int pickupFloor, int destFloor);

	public boolean addElevator(Elevator elevator);

	public boolean removeElevator(int elevatorId);

	public boolean stopElevator(int elevatorId);

	public boolean startElevator(int elevatorId);

	public List<Elevator> getElevators();

	public void start();
}
