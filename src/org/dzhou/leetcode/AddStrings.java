package org.dzhou.leetcode;

/**
 * 415. Add Strings
 * 
 * Difficulty: Easy
 * 
 * Given two non-negative numbers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * 
 * Both num1 and num2 contains only digits 0-9.
 * 
 * Both num1 and num2 does not contain any leading zero.
 * 
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * @author zhoudong
 *
 */
public class AddStrings {

	public String addStrings(String num1, String num2) {
		StringBuilder result = new StringBuilder();
		int x = num1.length() - 1, y = num2.length() - 1;
		int carry = 0, value = 0;
		while (x >= 0 || y >= 0) {
			value = carry;
			if (x >= 0)
				value += (num1.charAt(x--) - '0');
			if (y >= 0)
				value += (num2.charAt(y--) - '0');
			result.append(value % 10);
			carry = value / 10;
		}
		if (carry != 0)
			result.append(1);
		return result.reverse().toString();
	}

}
