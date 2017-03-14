package org.dzhou.other.facebook;

/**
 * 231. Power of Two
 * 
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * @author zhoudong
 *
 */
public class PowerOfTwo {

	class Bit_Solution {

		public boolean isPowerOfTwo(int n) {
			return n > 0 && (n & n - 1) == 0;
		}

	}

	class Mod_Solution {

		public boolean isPowerOfTwo(int n) {
			if (n < 1)
				return false;
			while (n % 2 == 0)
				n /= 2;
			return n == 1;
		}

	}

	class Recursive_Solution {

		public boolean isPowerOfTwo(int n) {
			if (n < 1) {
				return false;
			}
			if (n % 2 != 0) {
				return n == 1;
			} else {
				return isPowerOfTwo(n / 2);
			}
		}

	}

}
