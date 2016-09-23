package org.dzhou.leetcode;

/**
 * 13. Roman to Integer
 * 
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999. *
 * 
 * @author zhoudong
 *
 */
public class RomanToInteger {

	public int charToInt(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}

	public int romanToInt(String s) {
		int result = charToInt(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			int pre = charToInt(s.charAt(i - 1));
			int cur = charToInt(s.charAt(i));
			if (pre < cur)
				result -= 2 * pre;
			result += cur;
		}
		return result;
	}

}
