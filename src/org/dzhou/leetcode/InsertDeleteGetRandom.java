package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 380. Insert Delete GetRandom O(1)
 * 
 * Design a data structure that supports all following operations in average
 * O(1) time.
 * 
 * insert(val): Inserts an item val to the set if not already present.
 * 
 * remove(val): Removes an item val from the set if present.
 * 
 * getRandom: Returns a random element from current set of elements. Each
 * element must have the same probability of being returned.
 * 
 * @author zhoudong
 *
 */
public class InsertDeleteGetRandom {

	public class RandomizedSet {

		Map<Integer, Integer> map;
		List<Integer> list;
		Random random;

		/** Initialize your data structure here. */
		public RandomizedSet() {
			random = new Random();
			map = new HashMap<>();
			list = new ArrayList<>();
		}

		/**
		 * Inserts a value to the set. Returns true if the set did not already
		 * contain the specified element.
		 */
		public boolean insert(int val) {
			if (map.containsKey(val))
				return false;
			map.put(val, list.size());
			list.add(val);
			return true;
		}

		/**
		 * Removes a value from the set. Returns true if the set contained the
		 * specified element.
		 */
		public boolean remove(int val) {
			if (!map.containsKey(val))
				return false;
			int index = map.remove(val);
			int last = list.remove(list.size() - 1);
			if (last != val) {
				list.set(index, last);
				map.put(last, index);
			}
			return true;
		}

		/** Get a random element from the set. */
		public int getRandom() {
			if (list.size() == 0)
				return -1;
			if (list.size() == 1)
				return list.get(0);
			return list.get(random.nextInt(list.size()));
		}

	}

	// Your RandomizedSet object will be instantiated and called as such:
	// RandomizedSet obj = new RandomizedSet();
	// boolean param_1 = obj.insert(val);
	// boolean param_2 = obj.remove(val);
	// int param_3 = obj.getRandom();
}
