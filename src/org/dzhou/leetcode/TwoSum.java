package org.dzhou.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * 
 * return [0, 1].
 * 
 * UPDATE (2016/2/13):
 * 
 * The return format had been changed to zero-based indices. Please read the
 * above updated description carefully.
 * 
 * @author zhoudong
 *
 */
public class TwoSum {

	public class Solution {

		public int[] twoSum(int[] nums, int target) {
			if (nums == null || nums.length < 2)
				return null;

			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				map.put(nums[i], i);
			}

			for (int i = 0; i < nums.length; i++) {
				int difference = target - nums[i];
				if (map.containsKey(difference) && map.get(difference) != i) {
					return new int[] { i, map.get(difference) };
				}
			}

			return null;
		}
	}

}
