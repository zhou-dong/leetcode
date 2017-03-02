package org.dzhou.leetcode;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * 
 * Example2: x = -123, return -321
 * 
 * @author zhoudong
 *
 */
public class ReverseInteger {

	public class Solution {
		public int reverse(int x) {
			boolean isNegative = x < 0 ? true : false;
			if (isNegative)
				x *= -1;
			int result = 0;
			while (x > 0) {
				if (willOverflow(result, x))
					return 0;
				result *= 10;
				result += x % 10;
				x /= 10;
			}
			return isNegative ? result * -1 : result;
		}

		private boolean willOverflow(int number, int x) {
			if (number > Integer.MAX_VALUE / 10)
				return true;
			if ((number == Integer.MAX_VALUE / 10) && (x % 10 > Integer.MAX_VALUE % 10))
				return true;
			return false;
		}
	}

	public class Solution1 {

		public int reverse(int x) {
			Long result = 0L;
			while (x != 0) {
				result *= 10;
				result += x % 10;
				x /= 10;
			}
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
				return 0;
			return result.intValue();
		}

	}

}
