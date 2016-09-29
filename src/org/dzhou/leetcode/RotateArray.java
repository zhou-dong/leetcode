package org.dzhou.leetcode;

/**
 * 189. Rotate Array
 * 
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * Note: Try to come up as many solutions as you can, there are at least 3
 * different ways to solve this problem.
 * 
 * Hint:
 * 
 * Could you do it in-place with O(1) extra space?
 * 
 * @author zhoudong
 * 
 *         左边的k个数字是原来右边的，右边的n-k个数字是原来左边的。
 * 
 *         其实就是先把整个array reverse了。然后把左边k个reverse 再把右边n-k个reverse。
 */
public class RotateArray {

	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return;
		k %= nums.length;
		if (k == 0)
			return;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	private void reverse(int[] nums, int low, int high) {
		for (; low < high; low++, high--) {
			swap(nums, low, high);
		}
	}

	private void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}

}
