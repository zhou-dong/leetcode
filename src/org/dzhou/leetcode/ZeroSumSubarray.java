package org.dzhou.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Examples:
 * 
 * Input: {4, 2, -3, 1, 6} <br>
 * Output: true<br>
 * There is a subarray with zero sum from index 1 to 3.
 * 
 * Input: {4, 2, 0, 1, 6}<br>
 * Output: true<br>
 * There is a subarray with zero sum from index 2 to 2.<br>
 * 
 * Input: {-3, 2, 3, 1, 6} <br>
 * Output: false<br>
 * There is no subarray with zero sum.
 * 
 * @author zhoudong
 *
 */
public class ZeroSumSubarray {

	// arr: 4, 2, -3, 1, 6
	// sum: 4, 6, 3, 4, 10
	public int[] zeroSumIndices(int[] array) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0)
				return new int[] { i, i };
			sum += array[i];
			if (map.containsKey(sum)) {
				return new int[] { map.get(sum) + 1, i };
			}
			map.put(sum, i);
		}
		return null;
	}

}
