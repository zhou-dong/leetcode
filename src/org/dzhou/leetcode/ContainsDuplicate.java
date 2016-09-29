package org.dzhou.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 * 
 * Given an array of integers, find if the array contains any duplicates. Your
 * function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * 
 * @author zhoudong
 *
 */
public class ContainsDuplicate {

	// O(N)
	public class HashSet_Solution {
		public boolean containsDuplicate(int[] nums) {
			Set<Integer> set = new HashSet<>();
			for (int num : nums) {
				if (set.contains(num))
					return true;
				set.add(num);
			}
			return false;
		}
	}

	// O(NLog(N))
	public class Sort_Solution {
		public boolean containsDuplicate(int[] nums) {
			Arrays.sort(nums);
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] == nums[i - 1]) {
					return true;
				}
			}
			return false;
		}
	}

}
