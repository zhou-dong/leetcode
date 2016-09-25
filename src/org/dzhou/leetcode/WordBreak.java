package org.dzhou.leetcode;

import java.util.Set;

/**
 * 139. Word Break
 * 
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author zhoudong
 *
 */
public class WordBreak {

	public class DP_Two_Dimension_Solution {
		public boolean wordBreak(String s, Set<String> wordDict) {
			boolean[][] dp = new boolean[s.length()][s.length()];
			for (int k = 0; k < s.length(); k++) {
				for (int i = 0; i + k < s.length(); i++) {
					String str = s.substring(i, i + k + 1);
					if (wordDict.contains(str)) {
						dp[i][i + k] = true;
					} else {
						for (int j = 0; j < str.length(); j++) {
							if (dp[i][j] && dp[j + 1][i + k]) {
								dp[i][i + k] = true;
								break;
							}
						}
					}
				}
			}
			return dp[0][s.length() - 1];
		}
	}

	public class DP_One_Dimension_Solution {
		public boolean wordBreak(String s, Set<String> wordDict) {
			if (s == null || s.length() == 0)
				return true;
			boolean[] dp = new boolean[s.length() + 1];
			dp[0] = true;
			for (int i = 0; i < s.length(); i++) {
				StringBuilder str = new StringBuilder(s.substring(0, i + 1));
				for (int j = 0; j <= i; j++) {
					if (dp[j] && wordDict.contains(str.toString())) {
						dp[i + 1] = true;
						break;
					}
					str.deleteCharAt(0);
				}
			}
			return dp[s.length()];
		}
	}

}
