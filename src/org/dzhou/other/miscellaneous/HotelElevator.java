package org.dzhou.other.miscellaneous;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class HotelElevator {
	public int solution(int[] A, int[] B, int M, int X, int Y) {
		// write your code in Java SE 8
		Queue<Person> queue = new LinkedList<>();
		for (int i = 0; i < A.length; i++) {
			queue.add(new Person(A[i], B[i]));
		}

		int result = 0;

		int count = 0, weights = 0;
		Set<Integer> targets = new HashSet<>();
		while (!queue.isEmpty()) {
			if (count == X || (weights + queue.peek().weight) > Y) {
				result += (targets.size() + 1);
				count = 0;
				weights = 0;
				targets.clear();
			}
			Person person = queue.poll();
			count++;
			weights += person.weight;
			targets.add(person.target);
		}

		if (count != 0) {
			result += (targets.size() + 1);
		}

		return result;
	}

	class Person {
		int weight;
		int target;

		Person(int w, int t) {
			this.weight = w;
			this.target = t;
		}
	}

}
