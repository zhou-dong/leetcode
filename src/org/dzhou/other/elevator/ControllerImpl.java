package org.dzhou.other.elevator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ControllerImpl implements Controller {

	Map<Integer, Elevator> map = new HashMap<>();
	List<Elevator> elevators = new LinkedList<>();

	@Override
	public Elevator assignElevator(int pickupFloor, int destFloor) {
		Elevator result = null;
		int min = Integer.MAX_VALUE;
		for (Elevator elevator : elevators) {
			int distance = elevator.distance(pickupFloor, destFloor);
			if (distance < min) {
				min = distance;
				result = elevator;
			}
		}
		return result;
	}

	@Override
	public boolean addElevator(Elevator elevator) {
		if (elevator == null || map.containsKey(elevator.getId()))
			return false;
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

}
