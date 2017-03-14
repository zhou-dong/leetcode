package org.dzhou.other.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 15. 3Sum
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * @author zhoudong
 *
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {

		if (nums == null || nums.length < 3) {
			return Collections.emptyList();
		}

		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i <= nums.length - 3; i++) {

			if (i != 0 && nums[i] == nums[i - 1]) {
				continue; // remove duplicate
			}

			int low = i + 1, high = nums.length - 1;
			while (low < high) {
				int sum = nums[i] + nums[low] + nums[high];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[low], nums[high]));
					while (low < high && nums[low] == nums[low + 1])
						low++;// remove duplicate
					while (low < high && nums[high] == nums[high - 1])
						high--;// remove duplicate
					low++;
					high--;
				} else if (sum < 0) {
					low++;
				} else {
					high--;
				}
			}
		}

		return result;
	}

}
