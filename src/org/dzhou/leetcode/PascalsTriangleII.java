package org.dzhou.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author zhoudong
 *
 */
public class PascalsTriangleII {

	public List<Integer> getRow(int rowIndex) {
		if (rowIndex < 0) {
			return Collections.emptyList();
		}
		Integer[] result = new Integer[rowIndex + 1];
		for (int i = 0; i < result.length; i++) {
			result[i] = 1;
			for (int j = i - 1; j > 0; j--) {
				result[j] = result[j - 1] + result[j];
			}
		}
		return Arrays.asList(result);
	}

}
