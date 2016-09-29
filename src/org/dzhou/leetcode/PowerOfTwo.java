package org.dzhou.leetcode;

/**
 * 231. Power of Two
 * 
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * @author zhoudong
 *
 */
public class PowerOfTwo {

	public class Solution {
		public boolean isPowerOfTwo(int n) {
			if (n < 1)
				return false;
			while (n % 2 == 0)
				n /= 2;
			return n == 1;
		}
	}

	public class Solution1 {
		public boolean isPowerOfTwo(int n) {
			int result = 1;
			while (result <= n) {
				if (result == n)
					return true;
				result *= 2;
				if (result == 0) {// limit check
					return false;
				}
			}
			return false;
		}
	}

	public class Solution2 {
		public boolean isPowerOfTwo(int n) {
			return Integer.toString(n, 2).matches("^10*$");
		}
	}

	// 判断log以2为底n的对数是否为整数
	// Java没有log2,所以判断log10(n)/log10(2)是否为整数
	public class Solution3 {
		public boolean isPowerOfTwo(int n) {
			return (Math.log(n) / Math.log(2)) % 1 == 0;
		}
	}

	public class Solution4 {
		public boolean isPowerOfTwo(int n) {
			double epsilon = 0.00000001;
			return ((Math.log10(n) / Math.log10(2)) % 1 + epsilon) < 2 * epsilon;
		}
	}

}
