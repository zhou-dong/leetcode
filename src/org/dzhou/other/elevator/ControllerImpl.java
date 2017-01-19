package org.dzhou.other.elevator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ControllerImpl implements Controller {

	Map<Integer, Elevator> map = new HashMap<>();
	List<Elevator> elevators = new LinkedList<>();

	@Override
	public void assignElevator(int pickupFloor, int destFloor) {
		if (pickupFloor != destFloor) {
			findNearestElevator(pickupFloor, destFloor).addRequest(pickupFloor, destFloor);
		}
	}

	private Elevator findNearestElevator(int pickupFloor, int destFloor) {
		Elevator result = null;
		int min = Integer.MAX_VALUE;
		for (Elevator elevator : elevators) {
			int distance = elevator.distance(pickupFloor, destFloor);
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
	public List<Elevator> getElevators() {
		return elevators;
	}

	@Override
	public boolean stopElevator(int elevatorId) {
		return (!map.containsKey(elevatorId)) ? false : map.get(elevatorId).stop();
	}

	@Override
	public boolean startElevator(int elevatorId) {
		return (!map.containsKey(elevatorId)) ? false : map.get(elevatorId).start();
	}

}
