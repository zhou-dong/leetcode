package org.dzhou.leetcode;

/**
 * 171. Excel Sheet Column Number
 * 
 * Related to question Excel Sheet Column Title
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:<br>
 * 
 * A -> 1 <br>
 * B -> 2 <br>
 * C -> 3 <br>
 * ... <br>
 * Z -> 26 <br>
 * AA -> 27 <br>
 * AB -> 28 <br>
 * 
 * @author zhoudong
 * 
 *         实现26进制
 */
public class ExcelSheetColumnNumber {

	public int titleToNumber(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int result = 0;
		for (char c : s.toCharArray()) {
			result *= 26;
			result += c - 'A' + 1;
		}
		return result;
	}

}
