package org.dzhou.leetcode;

/**
 * 63. Unique Paths II
 * 
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * @author zhoudong
 *
 */
public class UniquePathsII {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 0;
		if (obstacleGrid[0][0] == 1)
			return 0;

		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
		dp[0][0] = 1;
		initFirstRow(obstacleGrid, dp);
		initFirstCol(obstacleGrid, dp);
		for (int row = 1; row < dp.length; row++) {
			for (int col = 1; col < dp[row].length; col++) {
				if (obstacleGrid[row][col] == 1) {
					dp[row][col] = 0;
				} else {
					dp[row][col] = dp[row][col - 1] + dp[row - 1][col];
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

	private void initFirstRow(int[][] obstacleGrid, int[][] dp) {
		for (int col = 1; col < dp[0].length; col++) {
			if (obstacleGrid[0][col] == 1) {
				dp[0][col] = 0;
			} else {
				dp[0][col] = dp[0][col - 1];
			}
		}
	}

	private void initFirstCol(int[][] obstacleGrid, int[][] dp) {
		for (int row = 1; row < dp.length; row++) {
			if (obstacleGrid[row][0] == 1) {
				dp[row][0] = 0;
			} else {
				dp[row][0] = dp[row - 1][0];
			}
		}
	}

}
