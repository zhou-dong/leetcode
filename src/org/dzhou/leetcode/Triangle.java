package org.dzhou.leetcode;

import java.util.List;

/**
 * 120. Triangle
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * @author zhoudong
 *
 */
public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.isEmpty()) {
			return 0;
		}

		int[] dp = new int[triangle.size()];
		// copy最后一层到result[]中
		for (int i = 0; i < triangle.size(); i++) {
			dp[i] = triangle.get(triangle.size() - 1).get(i);
		}

		// dynamic program
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j); // DP递推式
			}
		}
		return dp[0];
	}

}
