package org.dzhou.leetcode;

/**
 * 44. Wildcard Matching
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character. <br>
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: <br>
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples: <br>
 * isMatch("aa","a") → false <br>
 * isMatch("aa","aa") → true <br>
 * isMatch("aaa","aa") → false <br>
 * isMatch("aa", "*") → true <br>
 * isMatch("aa", "a*") → true <br>
 * isMatch("ab", "?*") → true <br>
 * isMatch("aab", "c*a*b") → false <br>
 * 
 * @author zhoudong
 *
 */
public class WildcardMatching {

	public boolean isMatch(String s, String p) {
		boolean[][] dpTable = createDpTable(s, p);
		runningDP(dpTable, s, p);
		return dpTable[dpTable.length - 1][dpTable[0].length - 1];
	}

	private void runningDP(boolean[][] dpTable, String string, String pattern) {
		for (int row = 1; row < dpTable.length; row++) {
			for (int col = 1; col < dpTable[row].length; col++) {
				if (pattern.charAt(col - 1) == '?' || pattern.charAt(col - 1) == string.charAt(row - 1)) {
					dpTable[row][col] = dpTable[row - 1][col - 1];
				} else if (pattern.charAt(col - 1) == '*') {
					dpTable[row][col] = dpTable[row][col - 1] || dpTable[row - 1][col];
				} else {
					dpTable[row][col] = false;
				}
			}
		}
	}

	private boolean[][] createDpTable(String string, String pattern) {
		boolean[][] dpTable = new boolean[string.length() + 1][pattern.length() + 1];
		dpTable[0][0] = true;
		for (int col = 1; col < dpTable[0].length; col++) {
			if (pattern.charAt(col - 1) == '*') {
				dpTable[0][col] = dpTable[0][col - 1];
			}
		}
		return dpTable;
	}

}
