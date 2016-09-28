package org.dzhou.leetcode;

/**
 * 137. Single Number II
 * 
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author zhoudong
 *
 *         这题也用位运算
 * 
 *         按照每一位对所有数字计算count
 * 
 */
public class SingleNumberII {

	// 按照每一位对所有数字计算count
	public class Bit_Solution {
		public int singleNumber(int[] nums) {
			int result = 0;
			for (int i = 0, count = 0; i < 32; i++, count = 0) {
				for (int j = 0; j < nums.length; j++)
					count += (nums[j] >> i) & 1;
				result |= (count % 3) << i;
			}
			return result;
		}
	}

	// count every number in every bit
	public class Array_Solution {
		public int singleNumber(int[] nums) {
			int[] count = new int[32];

			for (int num : nums) {
				for (int j = 0; j < 32; j++) {
					count[j] += (isOne(num, j) ? 1 : 0);
				}
			}

			int result = 0;
			for (int i = 0; i < count.length; i++) {
				result += ((count[i] % 3) << i);
			}
			return result;
		}

		private boolean isOne(int num, int index) {
			int mask = 1 << index;
			return (mask & num) != 0;
		}
	}

}
