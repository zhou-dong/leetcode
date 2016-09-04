package org.dzhou.leetcode;

/**
 * 303. Range Sum Query - Immutable
 * 
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * Example: <br>
 * 
 * Given nums = [-2, 0, 3, -5, 2, -1] <br>
 * 
 * sumRange(0, 2) -> 1 <br>
 * sumRange(2, 5) -> -1 <br>
 * sumRange(0, 5) -> -3 <br>
 * 
 * Note: <br>
 * You may assume that the array does not change. <br>
 * There are many calls to sumRange function. <br>
 * 
 * @author zhoudong
 *
 */
public class RangeSumQuery {

	public class NumArray {

		int[] dp = null;

		public NumArray(int[] nums) {
			if (nums == null || nums.length == 0)
				return;
			dp = new int[nums.length];
			dp[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				dp[i] = dp[i - 1] + nums[i];
			}
		}

		public int sumRange(int i, int j) {
			if (i < 0 || j > dp.length - 1 || i > j)
				return -1;
			return i == 0 ? dp[j] : dp[j] - dp[i - 1];
		}

	}

	// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.sumRange(1, 2);
}
