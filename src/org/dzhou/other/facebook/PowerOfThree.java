package org.dzhou.other.facebook;

/**
 * 
 * @author zhoudong
 *
 */
public class PowerOfThree {

	class Iterator_Solution {

		public boolean isPowerOfThree(int n) {
			if (n < 1)
				return false;
			while (n % 3 == 0)
				n /= 3;
			return n == 1;
		}

	}

	class Recursive_Solution {

		public boolean isPowerOfThree(int n) {
			if (n < 1)
				return false;
			if (n % 3 == 0) {
				return isPowerOfThree(n / 3);
			} else {
				return n == 1;
			}
		}

	}

	class Regular_Expression_Solution {

		public boolean isPowerOfThree(int n) {
			return Integer.toString(n, 3).matches("10*");
		}

	}

}
