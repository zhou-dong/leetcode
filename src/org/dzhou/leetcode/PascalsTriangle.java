package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * 
 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 * 
 * @author zhoudong
 *
 */
public class PascalsTriangle {

	public List<List<Integer>> generate(int numRows) {
		if (numRows < 1) {
			return Collections.emptyList();
		}

		List<List<Integer>> result = new ArrayList<>();

		List<Integer> zeroLevel = new ArrayList<>();
		zeroLevel.add(1);
		result.add(zeroLevel);

		for (int i = 1; i < numRows; i++) {
			List<Integer> prev = result.get(i - 1);
			List<Integer> curr = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				int value = (j == 0 || j == i) ? 1 : (prev.get(j - 1) + prev.get(j));
				curr.add(value);
			}
			result.add(curr);
		}

		return result;
	}

}
