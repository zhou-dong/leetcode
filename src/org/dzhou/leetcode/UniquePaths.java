package org.dzhou.leetcode;

import java.util.Arrays;

/**
 * 62. Unique Paths
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * @author zhoudong
 *
 */
public class UniquePaths {

	public int uniquePaths(int m, int n) {
		if (m <= 0 || n <= 0)
			return 0;
		if (m == 1 || n == 1)
			return 1;
		int[][] dp = new int[m][n];
		fillRow(dp[0], 1);
		fillCol(dp, 0, 1);
		for (int row = 1; row < m; row++) {
			for (int col = 1; col < n; col++) {
				dp[row][col] = dp[row][col - 1] + dp[row - 1][col];
			}
		}
		return dp[m - 1][n - 1];
	}

	private void fillRow(int[] row, int val) {
		Arrays.fill(row, val);
	}

	private void fillCol(int[][] matrix, int col, int value) {
		for (int row = 0; row < matrix.length; row++) {
			matrix[row][col] = value;
		}
	}

}
