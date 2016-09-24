package org.dzhou.leetcode;

/**
 * 80. Remove Duplicates from Sorted Array II
 * 
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new
 * length.
 * 
 * @author zhoudong
 *
 */
public class RemoveDuplicatesFromSortedArrayII {

	public class Three_Pointer_Solution {

		public int removeDuplicates(int[] nums) {
			if (nums == null)
				return 0;
			if (nums.length < 3)
				return nums.length;
			// [1,1,1,2,2,3],
			// [1,1,2,2]
			int prev = 0, curr = 1, next = 2;
			while (next < nums.length) {
				if (nums[curr] == nums[next] && nums[prev] == nums[curr]) {
					next++;
				} else {
					curr++;
					nums[curr] = nums[next];
					prev++;
					next++;
				}
			}
			return curr + 1;
		}

	}

	public class Two_Pointer_Solution1 {

		public int removeDuplicates(int[] nums) {
			if (nums == null)
				return 0;
			if (nums.length < 3)
				return nums.length;
			int prev = 1, curr = 2;
			while (curr < nums.length) {
				if (nums[prev] == nums[curr] && nums[prev - 1] == nums[prev]) {
					curr++;
				} else {
					prev++;
					nums[prev] = nums[curr];
					curr++;
				}

			}
			return prev + 1;
		}

	}

}