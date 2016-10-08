package org.dzhou.leetcode;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * 
 * Difficulty: Medium
 * 
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18],
 * 
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is
 * 4. Note that there may be more than one LIS combination, it is only necessary
 * for you to return the length.
 * 
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * @author zhoudong
 *
 *         reference: https://www.youtube.com/watch?v=CE2b_-XfVDk
 */
public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		return (nums == null || nums.length == 0) ? 0 : dpHelper(nums);
	}

	private int dpHelper(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return findMax(nums, dp);
	}

	private int findMax(int[] nums, int[] dp) {
		int max = 1;
		for (int num : dp)
			max = Math.max(max, num);
		return max;
	}

}
