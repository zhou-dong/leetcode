package org.dzhou.leetcode;

/**
 * 115. Distinct Subsequences
 * 
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 * @author zhoudong
 *
 *         - - r a b b b i t <br>
 *         - 1 1 1 1 1 1 1 1 <br>
 *         r 0 1 1 1 1 1 1 1 <br>
 *         a 0 0 1 1 1 1 1 1 <br>
 *         b 0 0 0 1 2 3 3 3 <br>
 *         b 0 0 0 0 1 3 3 3 <br>
 *         i 0 0 0 0 0 0 3 3 <br>
 *         t 0 0 0 0 0 0 0 3 <br>
 *
 */
public class DistinctSubsequences {

	// “When you see string problem that is about subsequence or matching,
	// dynamic programming method should come to your mind naturally. ”

	public int numDistinct(String s, String t) {
		if (s == null || t == null)
			return 0;
		if (s.isEmpty())
			return t.isEmpty() ? 1 : 0;

		int[][] dp = new int[t.length() + 1][s.length() + 1];
		// first row
		for (int col = 0; col < dp[0].length; col++) {
			dp[0][col] = 1;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (t.charAt(i - 1) == s.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		return dp[t.length()][s.length()];
	}
}
