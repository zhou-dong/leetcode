package org.dzhou.leetcode;

/**
 * 494. Target Sum
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target,
 * S. Now you have 2 symbols + and -. For each integer, you should choose one
 * from + and - as its new symbol.
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.
 * 
 * @author zhoudong
 *
 */
public class TargetSum {

	int count = 0;

	public int findTargetSumWays(int[] nums, int S) {
		helper(nums, S, 0, 0);
		return count;
	}

	private void helper(int[] nums, int target, int position, int sum) {
		if (position == nums.length) {
			if (sum == target) {
				count++;
			}
			return;
		}
		helper(nums, target, position + 1, sum + nums[position]);
		helper(nums, target, position + 1, sum - nums[position]);
	}

}
