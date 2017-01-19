package org.dzhou.other.elevator.practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.dzhou.other.elevator.practice.Elevator;

public class ControllerImpl implements Controller {

	Map<Integer, Elevator> map = new HashMap<>();
	List<Elevator> elevators = new LinkedList<>();

	@Override
	public void assignElevator(int pickupFloor, int destFloor) {
		if (pickupFloor != destFloor) {
			nearestElevator(pickupFloor, destFloor).addRequest(pickupFloor, destFloor);
		}
	}

	private Elevator nearestElevator(int pickupFloor, int destFloor) {
		Elevator result = null;
		int min = Integer.MAX_VALUE;
		for (Elevator elevator : elevators) {
			int distance = elevator.distanceToPickup(pickupFloor, destFloor);
			if (distance == -1) {
				continue;
			}
			if (distance < min) {
				min = distance;
				result = elevator;
			}
		}
		if (result == null)
			throw new RuntimeException("No available elevator");
		return result;
	}

	@Override
	public boolean addElevator(Elevator elevator) {
		if (elevator == null)
			return false;
		if (map.containsKey(elevator.getId()))
			throw new RuntimeException("Duplicated id:" + elevator.getId());
		map.put(elevator.getId(), elevator);
		elevators.add(elevator);
		return true;
	}

	@Override
	public boolean removeElevator(int elevatorId) {
		if (!map.containsKey(elevatorId))
			return false;
		elevators.remove(map.get(elevatorId));
		map.remove(elevatorId);
		return true;
	}

	@Override
	public boolean stopElevator(int elevatorId) {
		return (!map.containsKey(elevatorId)) ? false : map.get(elevatorId).stop();
	}

	@Override
	public boolean startElevator(int elevatorId) {
		return (!map.containsKey(elevatorId)) ? false : map.get(elevatorId).start();
	}

	@Override
	public List<Elevator> getElevators() {
		return elevators;
	}

	@Override
	public void start() {
		for (Elevator elevator : elevators) {
			elevator.start();
		}
	}

}
