package org.dzhou.leetcode;

import java.util.Arrays;

/**
 * 268. Missing Number
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find
 * the one that is missing from the array.
 * 
 * For example, Given nums = [0, 1, 3] return 2.
 * 
 * Note: Your algorithm should run in linear runtime complexity. Could you
 * implement it using only constant extra space complexity?
 * 
 * @author zhoudong
 *
 */
public class MissingNumber {

	// 用等差数列的求和公式求出0到n之间所有的数字之和，然后再遍历数组算出给定数字的累积和，然后做减法，差值就是丢失的那个数字
	public class Math_Solution {
		public int missingNumber(int[] nums) {
			int sum = 0;
			for (int n : nums)
				sum += n;
			return (nums.length * (nums.length + 1) - (sum * 2)) / 2;
		}
	}

	public class Bit_Solution {
		public int missingNumber(int[] nums) {
			int result = 0;
			for (int i = 0; i <= nums.length; i++) {
				result ^= i;
			}
			for (int num : nums) {
				result ^= num;
			}
			return result;
		}
	}

	public class Binary_Search_Solution {
		public int missingNumber(int[] nums) {
			Arrays.sort(nums);
			int left = 0, right = nums.length;
			while (left < right) {
				int mid = (left + right) / 2;
				if (nums[mid] > mid)
					right = mid;
				else {
					left = mid + 1;
				}
			}
			return right;
		}
	}

}
