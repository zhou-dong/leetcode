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
