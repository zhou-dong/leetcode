package org.dzhou.leetcode;

/**
 * 371. Sum of Two Integers
 * 
 * Difficulty: Easy
 * 
 * Calculate the sum of two integers a and b, but you are not allowed to use the
 * operator + and -.
 * 
 * Example: Given a = 1 and b = 2, return 3.
 * 
 * @author zhoudong
 *
 *         reference: http://www.cnblogs.com/grandyang/p/5451942.html
 * 
 *         我们在做加法运算的时候，每位相加之后可能会有进位Carry产生，然后在下一位计算时需要加上进位一起运算，
 *         那么我们能不能将两部分拆开呢，我们来看一个例子759+674
 * 
 *         1. 如果我们不考虑进位，可以得到323 <br>
 *         2. 如果我们只考虑进位，可以得到1110 <br>
 *         3. 我们把两个数字相加，323+1110=1433就是最终结果了
 * 
 *         然后我们进一步分析，如果得到上面的第一第二种情况，我们在二进制下来看，<br>
 *         不考虑进位的加，0+0=0, 0+1=1, 1+0=1, 1+1=0，这就是异或的运算规则，<br>
 *         只考虑进位的加，0+0=0, 0+1=0, 1+0=0, 1+1=1，而这其实这就是与的运算，<br>
 *         而第三步在将两者相加时，我们再递归调用这个算法，终止条件是当进位为0.
 * 
 */
public class SumOfTwoIntegers {

	public class Solution {
		public int getSum(int a, int b) {
			while (b != 0) {
				int carry = (a & b) << 1;
				a = a ^ b;
				b = carry;
			}
			return a;
		}
	}

	public class Test_Solution {
		public int getSum(int a, int b) {
			int carry = (a & b) << 1;
			a = a ^ b;
			return a + carry;
		}
	}
}
