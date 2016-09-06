package org.dzhou.leetcode;

/**
 * 10. Regular Expression Matching
 * 
 * mplement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. <br>
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: <br>
 * isMatch("aa","a") → false <br>
 * isMatch("aa","aa") → true <br>
 * isMatch("aaa","aa") → false <br>
 * isMatch("aa", "a*") → true <br>
 * isMatch("aa", ".*") → true <br>
 * isMatch("ab", ".*") → true <br>
 * isMatch("aab", "c*a*b") → true <br>
 * 
 * @author zhoudong
 *
 */
public class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
		boolean[][] dp = createDpTable(s, p);
		runningDP(s, p, dp);
		return dp[s.length()][p.length()];
	}

	private void runningDP(String string, String pattern, boolean[][] dp) {
		for (int row = 1; row < dp.length; row++) {
			char s = string.charAt(row - 1);
			for (int col = 1; col < dp[0].length; col++) {
				char p = pattern.charAt(col - 1);
				if (isMatch(s, p)) {
					dp[row][col] = dp[row - 1][col - 1];
				} else if (p == '*') {
					if (dp[row][col - 2]) {
						dp[row][col] = true;
					} else {
						if (isMatch(s, pattern.charAt(col - 2))) {
							dp[row][col] = dp[row - 1][col];
						}
					}
				} else {
					dp[row][col] = false;
				}
			}
		}
	}

	private boolean[][] createDpTable(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int col = 1; col < dp[0].length; col++) {
			if (p.charAt(col - 1) == '*') {
				dp[0][col] = dp[0][col - 2];
			}
		}
		return dp;
	}

	private boolean isMatch(char s, char p) {
		return p == '.' || p == s;
	}

}
