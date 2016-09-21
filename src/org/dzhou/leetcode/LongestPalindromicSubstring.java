package org.dzhou.leetcode;

/**
 * 5. Longest Palindromic Substring
 * 
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 * @author zhoudong
 *
 */
public class LongestPalindromicSubstring {

	public class Dynamic_Programming_Solution {

		public String longestPalindrome(String s) {
			if (s == null || s.length() < 2)
				return s;

			String longest = s.charAt(0) + "";

			boolean[][] dp = new boolean[s.length()][s.length()];

			// set each character to be palindrome
			for (int i = 0; i < dp.length; i++) {
				dp[i][i] = true;
			}

			// check two characters word is palindrome or not
			for (int i = 0; i < dp.length - 1; i++) {
				if (s.charAt(i) == s.charAt(i + 1)) {
					dp[i][i + 1] = true;
					if (longest.length() < 2) {
						longest = s.substring(i, i + 2);
					}
				}
			}

			// more than two characters word
			for (int len = 2; len < dp.length; len++) {
				for (int low = 0; low < dp.length; low++) {
					if (s.charAt(low) == s.charAt(low + len)) {
						if (dp[low + 1][low + len - 1]) {
							dp[low][low + len] = true;
							if (longest.length() < len) {
								longest = s.substring(low, low + len + 1);
							}
						}
					}
				}
			}
			return longest;
		}

	}

	// 中心扩散法
	public class Spread_From_Center_Solution {
		String longest = "";

		public String longestPalindrome(String s) {
			for (int i = 0; i < s.length(); i++) {
				helper(i - 1, i + 1, s); // 计算奇数子字符串
				helper(i, i + 1, s); // 计算偶数子字符串
			}
			return longest;
		}

		private void helper(int left, int right, String s) {
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			String current = s.substring(left + 1, right);
			longest = longest.length() < current.length() ? current : longest;
		}
	}

	// Time Limit Exceeded
	public class Brute_Force_Solution1 {

		public String longestPalindrome(String s) {
			if (s == null || s.length() == 0)
				return "";

			int max = 1;
			String longest = s.charAt(0) + "";

			for (int i = 0; i < s.length(); i++) {
				for (int j = i + 1; j < s.length(); j++) {
					String sub = s.substring(i, j + 1);
					if (!isPalindrome(sub))
						continue;
					if (sub.length() > max) {
						max = sub.length();
						longest = sub;
					}
				}
			}

			return longest;
		}

		private boolean isPalindrome(String s) {
			for (int low = 0, high = s.length() - 1; low < high; low++, high--) {
				if (s.charAt(low) != s.charAt(high))
					return false;
			}
			return true;
		}
	}

}
