package org.dzhou.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. Contains Duplicate II
 * 
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * difference between i and j is at most k.
 * 
 * @author zhoudong
 *
 */
public class ContainsDuplicateII {

	public class HashTable_Solution {

		public boolean containsNearbyDuplicate(int[] nums, int k) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				int num = nums[i];
				if (map.containsKey(num) && (i - map.get(num) <= k)) {
					return true;
				}
				map.put(num, i);
			}
			return false;
		}

	}

	public class Naive_approach_Solution {

		public boolean containsNearbyDuplicate(int[] nums, int k) {
			for (int i = 0; i < nums.length - 1; i++) {
				for (int j = i + 1; j < nums.length && j <= i + k; j++) {
					if (nums[i] == nums[j]) {
						return true;
					}
				}
			}
			return false;
		}

	}

}
