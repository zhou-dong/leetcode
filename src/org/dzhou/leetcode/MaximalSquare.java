package org.dzhou.leetcode;

/**
 * 221. Maximal Square
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * @author zhoudong
 *
 */
public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int max = 0;
		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

		for (int row = 1; row < dp.length; row++) {
			for (int col = 1; col < dp[0].length; col++) {
				if (matrix[row - 1][col - 1] != '0') {
					int min = 1 + min(dp[row - 1][col - 1], dp[row - 1][col], dp[row][col - 1]);
					max = Math.max(max, min);
					dp[row][col] = min;
				}
			}
		}

		return max * max;
	}

	private int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

}
