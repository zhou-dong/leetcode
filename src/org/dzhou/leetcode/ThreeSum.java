package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 5. 3Sum
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: <br>
 * [ <br>
 * - [-1, 0, 1], <br>
 * - [-1, -1, 2] <br>
 * ] <br>
 * 
 * @author zhoudong
 *
 */
public class ThreeSum {

	public class Solution {

		public List<List<Integer>> threeSum(int[] nums) {
			if (nums == null || nums.length < 3)
				return Collections.emptyList();

			List<List<Integer>> result = new ArrayList<>();
			Set<List<Integer>> set = new HashSet<>();

			Arrays.sort(nums);
			for (int i = 0; i < nums.length - 2; i++) {
				// optimize
				if (i != 0 && nums[i] == nums[i - 1]) {
					continue;
				}
				int low = i + 1, high = nums.length - 1;
				while (low < high) {
					int sum = nums[i] + nums[low] + nums[high];
					if (sum == 0) {
						List<Integer> item = Arrays.asList(new Integer[] { nums[i], nums[low], nums[high] });
						if (!set.contains(item)) {
							set.add(item);
							result.add(item);
						}
						low++;
						high--;
					} else if (sum > 0) {
						high--;
					} else {
						low++;
					}
				}

			}

			return result;
		}

	}

	// Time Limit Exceeded
	public class Solution1 {
		public List<List<Integer>> threeSum(int[] nums) {
			if (nums == null || nums.length < 3)
				return Collections.emptyList();

			List<List<Integer>> result = new ArrayList<>();
			for (int i = 0; i < nums.length - 2; i++) {
				for (int j = i + 1; j < nums.length - 1; j++) {
					for (int k = j + 1; k < nums.length; k++) {
						if (nums[i] + nums[j] + nums[k] == 0) {
							List<Integer> item = Arrays.asList(new Integer[] { nums[i], nums[j], nums[k] });
							Collections.sort(item);
							if (!result.contains(item)) {
								result.add(item);
							}
						}
					}
				}
			}

			return result;
		}
	}

}
