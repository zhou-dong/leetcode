package org.dzhou.leetcode;

/**
 * 67. Add Binary
 * 
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, <br>
 * a = "11" <br>
 * b = "1" <br>
 * Return "100". <br>
 * 
 * @author zhoudong
 *
 */
public class AddBinary {

	// iterator
	public class Solution {

		public String addBinary(String a, String b) {
			StringBuilder sb = new StringBuilder();

			int carry = 0;
			for (int x = a.length() - 1, y = b.length() - 1; x >= 0 || y >= 0; x--, y--) {
				int sum = carry;
				sum += (x < 0) ? 0 : getBit(a.charAt(x));
				sum += (y < 0) ? 0 : getBit(b.charAt(y));
				sb.append(sum % 2);
				carry = sum / 2;
			}

			if (carry != 0)
				sb.append(1);
			return sb.reverse().toString();
		}

		private int getBit(char c) {
			return c == '0' ? 0 : 1;
		}

	}

	// recursive
	public class Solution1 {

		public String addBinary(String a, String b) {
			StringBuilder sb = new StringBuilder();
			recursive(a, b, a.length() - 1, b.length() - 1, sb, 0);
			return sb.reverse().toString();
		}

		private void recursive(String a, String b, int x, int y, StringBuilder sb, int carry) {
			if (x < 0 && y < 0) {
				if (carry == 1)
					sb.append(1);
				return;
			}
			int sum = carry;
			sum += (x < 0) ? 0 : getBit(a.charAt(x));
			sum += (y < 0) ? 0 : getBit(b.charAt(y));
			sb.append(sum % 2);
			recursive(a, b, x - 1, y - 1, sb, sum / 2);
		}

		private int getBit(char c) {
			return c == '0' ? 0 : 1;
		}

	}

}
