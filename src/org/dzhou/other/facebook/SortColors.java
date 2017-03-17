package org.dzhou.other.facebook;

/**
 * 75. Sort Colors
 * 
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Follow up:
 * 
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort. First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * @author zhoudong
 *
 */
public class SortColors {

	public void sortColors(int[] nums) {
		if (nums == null || nums.length < 2)
			return;
		sortRed(nums);
		sortBlue(nums);
	}

	private void sortRed(int[] nums) {
		for (int slow = 0; slow < nums.length; slow++) {
			if (nums[slow] == 0) {
				continue;
			}
			int fast = slow + 1;
			while (fast < nums.length && nums[fast] != 0) {
				fast++;
			}
			if (fast == nums.length)
				break;
			swap(nums, slow, fast);
		}
	}

	private void sortBlue(int[] nums) {
		for (int slow = nums.length - 1; slow >= 0; slow--) {
			if (nums[slow] == 2) {
				continue;
			}
			int fast = slow - 1;
			while (fast >= 0 && nums[fast] != 2) {
				fast--;
			}
			if (fast < 0)
				break;
			swap(nums, slow, fast);
		}
	}

	private void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}

}
