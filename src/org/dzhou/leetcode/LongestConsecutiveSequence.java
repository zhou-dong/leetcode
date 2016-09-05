package org.dzhou.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * 
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2],
 * 
 * The longest consecutive elements sequence is [1, 2, 3, 4]. <br>
 * Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @author zhoudong
 *
 */
public class LongestConsecutiveSequence {

	public class Solution {

		public int longestConsecutive(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;

			Set<Integer> set = new HashSet<>();
			for (int num : nums) {
				set.add(num);
			}

			int max = 1;
			for (int num : nums) {
				if (!set.contains(num)) {
					continue;
				}

				int count = 1;
				set.remove(num);

				int temp = num;
				while (set.contains(++temp)) {
					count++;
					set.remove(temp);
				}

				while (set.contains(--num)) {
					count++;
					set.remove(num);
				}

				max = Math.max(max, count);
			}
			return max;
		}
	}

}
