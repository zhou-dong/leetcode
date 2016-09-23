package org.dzhou.leetcode;

/**
 * 8. String to Integer (atoi)
 * 
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * @author zhoudong
 *
 */
public class StringToIntegerAtoi {

	public class Solution {

		public int myAtoi(String str) {
			if (str == null || str.length() == 0 || str.trim().length() == 0)
				return 0;
			str = str.trim();
			boolean positive = true;
			int i = 0;
			if (str.charAt(0) == '+')
				i++;
			else if (str.charAt(0) == '-') {
				positive = false;
				i++;
			}
			double temp = 0;
			for (; i < str.length(); i++) {
				int digit = str.charAt(i) - '0';
				if (digit < 0 || digit > 9)
					break;
				if (positive) {
					temp = temp * 10 + digit;
					if (temp > Integer.MAX_VALUE)
						return Integer.MAX_VALUE;
				} else {
					temp = temp * 10 - digit;
					if (temp < Integer.MIN_VALUE)
						return Integer.MIN_VALUE;
				}
			}
			return (int) temp;
		}

	}

	public class Solution1 {
		public int myAtoi(String str) {
			if (str == null || str.length() == 0 || str.trim().length() == 0)
				return 0;
			str = str.trim();
			if (str.charAt(0) == '+')
				return positive(str.substring(1));
			else if (str.charAt(0) == '-')
				return negative(str.substring(1));
			return positive(str);
		}

		private int positive(String s) {
			double temp = 0;
			for (char c : s.toCharArray()) {
				int digit = c - '0';
				if (digit < 0 || digit > 9) {
					break;
				}
				temp = temp * 10 + digit;
				if (temp > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				}
			}
			return (int) temp;
		}

		private int negative(String s) {
			double temp = 0;
			for (char c : s.toCharArray()) {
				int digit = c - '0';
				if (digit < 0 || digit > 9) {
					break;
				}
				temp = temp * 10 - digit;
				if (temp < Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
			}
			return (int) temp;
		}

	}

}
