package org.dzhou.leetcode;

import java.util.Arrays;

/**
 * 259. 3Sum Smaller
 * 
 * Given an array of n integers nums and a target, find the number of index
 * triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] +
 * nums[j] + nums[k] < target.
 * 
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * 
 * Return 2. Because there are two triplets which sums are less than 2:
 * 
 * [-2, 0, 1] <br>
 * [-2, 0, 3]
 * 
 * Follow up: Could you solve it in O(n2) runtime?
 * 
 * @author zhoudong
 *
 */
public class ThreeSumSmaller {

	public int threeSumSmaller(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return 0;

		Arrays.sort(nums);

		int count = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int low = i + 1, high = nums.length - 1;
			while (low < high) {
				int sum = nums[i] + nums[low] + nums[high];
				if (sum >= target) {
					high--;
				} else {
					// right - left个组合都是小于目标数的
					count += high - low;
					low++;
				}
			}
		}

		return count;
	}

}
