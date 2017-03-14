package org.dzhou.other.facebook;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * 
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing
 * subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may
 * be more than one LIS combination, it is only necessary for you to return the
 * length.
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
		return (nums == null || nums.length == 0) ? 0 : dp(nums);
	}

	private int dp(int[] nums) {
		// 3 4 -1 0 6 2 3
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int max = 1;
		for (int count : dp) {
			max = Math.max(max, count);
		}
		return max;
	}

}
