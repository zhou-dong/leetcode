package org.dzhou.other.elevator;

import java.util.TreeSet;

public class ElevatorImpl {

	public enum Direction {
		UP, DOWN, IDLE;
	}

	class Destination implements Comparable<Destination> {
		int floor;
		int toLeavePeople;

		@Override
		public int compareTo(Destination other) {
			return this.floor - other.floor;
		}
	}

	private int currFloor;
	private int capacity;
	private int currSize;
	private Direction direction;

	TreeSet<Destination> stops = new TreeSet<>();

	public int nextFloor() {

		return 0;
	}

	public int destFloor() {

		return 0;
	}

	public int distance(int request) {

		return 0;
	}

}
