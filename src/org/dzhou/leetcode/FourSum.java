package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 18. 4Sum
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is: <br>
 * [ <br>
 * --[-1, 0, 0, 1], <br>
 * --[-2, -1, 1, 2], <br>
 * --[-2, 0, 0, 2] <br>
 * ] <br>
 * 
 * @author zhoudong
 *
 */
public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		if (nums == null || nums.length < 4)
			return Collections.emptyList();
		List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {

				int low = j + 1, high = nums.length - 1;
				while (low < high) {
					int sum = nums[i] + nums[j] + nums[low] + nums[high];
					if (sum == target) {
						List<Integer> item = Arrays.asList(new Integer[] { nums[i], nums[j], nums[low], nums[high] });
						if (!result.contains(item))
							result.add(item);
						low++;
						high--;
					} else if (sum > target) {
						high--;
					} else {
						low++;
					}
				}

			}
		}

		return result;
	}

}
