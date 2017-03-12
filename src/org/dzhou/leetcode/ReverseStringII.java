package org.dzhou.leetcode;

/**
 * 541. Reverse String II
 * 
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original.
 * 
 * Example: Input: s = "abcdefg", k = 2 Output: "bacdfeg"
 * 
 * Restrictions: <br>
 * The string consists of lower English letters only. <br>
 * Length of the given string and k will in the range [1, 10000]
 * 
 * @author zhoudong
 *
 */
public class ReverseStringII {

	public String reverseStr(String s, int k) {
		char[] array = s.toCharArray();
		for (int i = 0; i < s.length(); i += 2 * k)
			reverse(array, i, Math.min(s.length() - 1, i + k - 1));
		return new String(array);
	}

	private void reverse(char[] array, int low, int high) {
		for (; low < high; low++, high--) {
			swap(array, low, high);
		}
	}

	private void swap(char[] array, int x, int y) {
		char temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

}
