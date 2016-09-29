package org.dzhou.leetcode;

/**
 * 283. Move Zeroes
 * 
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
 * should be [1, 3, 12, 0, 0].
 * 
 * Note:
 * 
 * You must do this in-place without making a copy of the array.
 * 
 * Minimize the total number of operations.
 * 
 * @author zhoudong
 *
 *
 */
public class MoveZeroes {

	// http://fisherlei.blogspot.com/2015/10/leetcode-move-zeroes-solution.html
	public class Two_Pointer_Solution {
		public void moveZeroes(int[] nums) {
			int zero_index = 0, none_zero_index = 0;
			while (none_zero_index < nums.length && zero_index < nums.length) {
				if (nums[zero_index] != 0) {
					zero_index++;
					none_zero_index = zero_index;
					continue;
				}
				if (nums[none_zero_index] == 0) {
					none_zero_index++;
					continue;
				}
				swap(nums, zero_index, none_zero_index);
				zero_index++;
				none_zero_index++;
			}
		}

		private void swap(int[] nums, int i, int j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}

	public class BubbleSort_Solution {
		public void moveZeroes(int[] nums) {
			for (int i = nums.length - 1; i >= 0; i--) {
				for (int j = 0; j < i; j++) {
					if (nums[j] == 0) {
						swap(nums, j, j + 1);
					}
				}
			}
		}

		private void swap(int[] nums, int i, int j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}

}
