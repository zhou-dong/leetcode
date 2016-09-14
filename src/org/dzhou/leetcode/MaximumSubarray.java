package org.dzhou.leetcode;

/**
 * 53. Maximum Subarray
 * 
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray
 * [4,-1,2,1] has the largest sum = 6.
 * 
 * @author zhoudong
 *
 */
public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE, curr = 0;

		for (int i = 0; i < nums.length; i++) {
			curr += nums[i];
			max = Math.max(max, curr);
			curr = curr < 0 ? 0 : curr;
		}

		return max;
	}

}
