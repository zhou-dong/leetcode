package org.dzhou.leetcode;

/**
 * 64. Minimum Path Sum
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * @author zhoudong
 *
 */
public class MinimumPathSum {

	public int minPathSum(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		copyFirstRow(grid, dp);
		copyFirstCol(grid, dp);
		for (int row = 1; row < grid.length; row++) {
			for (int col = 1; col < grid[0].length; col++) {
				dp[row][col] = grid[row][col] + Math.min(dp[row - 1][col], dp[row][col - 1]);
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

	private void copyFirstRow(int[][] grid, int[][] dp) {
		for (int col = 1; col < dp[0].length; col++) {
			dp[0][col] = dp[0][col - 1] + grid[0][col];
		}
	}

	private void copyFirstCol(int[][] grid, int[][] dp) {
		for (int row = 1; row < dp.length; row++) {
			dp[row][0] = dp[row - 1][0] + grid[row][0];
		}
	}

}
