package org.dzhou.other.dp;

/**
 * Longest Common Subsequence
 * 
 * @author zhoudong
 *
 */
public class LongestCommonSubsequence {

	public int countMaxLength(String str1, String str2) {
		if (str1 == null || str2 == null) {
			throw new IllegalArgumentException();
		}
		if (str1.length() == 0 || str2.length() == 0) {
			return 0;
		}
		return dp(str1, str2);
	}

	private int dp(String str1, String str2) {
		int[][] table = new int[str1.length() + 1][str2.length() + 1];
		for (int row = 1; row < table.length; row++) {
			for (int col = 1; col < table[row].length; col++) {
				if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
					table[row][col] = table[row - 1][col - 1] + 1;
				} else {
					table[row][col] = Math.max(table[row - 1][col], table[row][col - 1]);
				}
			}
		}
		return table[table.length - 1][table[0].length - 1];
	}

}
