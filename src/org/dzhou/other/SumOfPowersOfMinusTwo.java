package org.dzhou.other;

import java.util.HashMap;
import java.util.Map;

public class SumOfPowersOfMinusTwo {

	public int solution(int[] A) {

		Map<Integer, Double> cache = new HashMap<>();
		for (int num : A) {
			if (!cache.containsKey(num)) {
				cache.put(num, Math.pow(2, num));
			}
		}

		Double total = 0.0;
		for (int num : A) {
			if (num % 2 == 0) {
				total += cache.get(num);
			} else {
				total -= cache.get(num);
			}
		}

		return total.intValue();
	}

}
