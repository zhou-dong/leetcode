package org.dzhou.leetcode;

/**
 * 72. Edit Distance
 * 
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * 
 * b) Delete a character
 * 
 * c) Replace a character
 * 
 * @author zhoudong
 *
 */
public class EditDistance {

	public int minDistance(String word1, String word2) {
		int[][] dp = createDpTable(word1.length() + 1, word2.length() + 1);
		runningDP(dp, word1, word2);
		return dp[dp.length - 1][dp[0].length - 1];
	}

	private void runningDP(int[][] dp, String word1, String word2) {
		for (int row = 1; row < dp.length; row++) {
			for (int col = 1; col < dp[row].length; col++) {
				if (word1.charAt(row - 1) == word2.charAt(col - 1)) {
					dp[row][col] = dp[row - 1][col - 1];
				} else {
					int replace = dp[row - 1][col - 1] + 1;
					int insert = dp[row][col - 1] + 1;
					int delete = dp[row - 1][col] + 1;
					dp[row][col] = Math.min(replace, Math.min(insert, delete));
				}
			}
		}
	}

	private int[][] createDpTable(int rowLen, int colLen) {
		int[][] dp = new int[rowLen][colLen];
		dp[0][0] = 0;
		init1thRow(dp);
		init1thCol(dp);
		return dp;
	}

	private void init1thRow(int[][] dp) {
		for (int col = 1; col < dp[0].length; col++) {
			dp[0][col] = col;
		}
	}

	private void init1thCol(int[][] dp) {
		for (int row = 1; row < dp.length; row++) {
			dp[row][0] = row;
		}
	}

}
