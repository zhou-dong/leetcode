package org.dzhou.leetcode;

/**
 * 326. Power of Three
 * 
 * Given an integer, write a function to determine if it is a power of three.
 * 
 * Follow up: Could you do it without using any loop / recursion?
 * 
 * @author zhoudong
 *
 */
public class PowerOfThree {

	public class Solution {
		public boolean isPowerOfThree(int n) {
			if (n < 1)
				return false;
			while (n % 3 == 0)
				n /= 3;
			return n == 1;
		}
	}

	public class Solution1 {
		public boolean isPowerOfThree(int n) {
			int result = 1;
			while (result <= n) {
				if (result == n)
					return true;
				result *= 3;
				if (result == 0) {// limit check
					return false;
				}
			}
			return false;
		}
	}

	public class Solution2 {
		public boolean isPowerOfThree(int n) {
			return Integer.toString(n, 3).matches("^10*$");
		}
	}

	// 判断log以3为底n的对数是否为整数
	// Java没有log3,所以判断log10(n)/log10(3)是否为整数
	public class Solution3 {
		public boolean isPowerOfThree(int n) {
			// return (Math.log10(n) / Math.log(3)) % 1 == 0;
			double epsilon = 0.00000001;
			return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
		}
	}

	public class Solution4 {
		public boolean isPowerOfThree(int n) {
			return n > 0 && 1162261467 % n == 0;
		}
	}

	public class Solution5 {
		public boolean isPowerOfThree(int n) {
			while (n >= 1) {
				if (n == 1)
					return true;
				if (n % 3 != 0)
					return false;
				n /= 3;
			}
			return false;
		}
	}

}
