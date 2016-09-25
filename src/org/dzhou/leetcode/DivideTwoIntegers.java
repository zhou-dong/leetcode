package org.dzhou.leetcode;

/**
 * 29. Divide Two Integers
 * 
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 * 
 * @author zhoudong
 *
 */
public class DivideTwoIntegers {
	// 这个我们就得使用位运算。我们知道任何一个整数可以表示成以2的幂为底的一组基的线性组合，
	// 即number=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n。
	// 基于以上这个公式以及左移一位相当于乘以2， 我们先让除数左移直到大于被除数之前得到一个最大的基。
	// 然后接下来我们每次尝试减去这个基，如果可以则结果增加加2^k,然后基继续右移迭代，直到基为0为止。
	// 因为这个方法的迭代次数是按2的幂直到超过结果， 所以时间复杂度为O(log(n))。

	public class Solution {

		// 基本思想就是把除数向左移位(×2)然后与被除数比较，直到发现仅次于被除数的那个值，减去该值后继续。
		public int divide(int dividend, int divisor) {

			if (divisor == 0)
				return Integer.MAX_VALUE;

			boolean isNeg = (dividend ^ divisor) >>> 31 == 1;

			int res = 0;
			if (dividend == Integer.MIN_VALUE) {
				dividend += Math.abs(divisor);
				if (divisor == -1) {
					return Integer.MAX_VALUE;
				}
				res++;
			}
			if (divisor == Integer.MIN_VALUE) {
				return res;
			}

			dividend = Math.abs(dividend);
			divisor = Math.abs(divisor);

			int digit = 0;
			while (divisor <= (dividend >> 1)) {
				divisor <<= 1;
				digit++;
			}
			while (digit >= 0) {
				if (dividend >= divisor) {
					res += 1 << digit;
					dividend -= divisor;
				}
				divisor >>= 1;
				digit--;
			}
			return isNeg ? -res : res;
		}
	}

}
