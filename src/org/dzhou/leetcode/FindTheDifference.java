package org.dzhou.leetcode;

/**
 * 389. Find the Difference
 * 
 * Given two strings s and t which consist of only lowercase letters.
 * 
 * String t is generated by random shuffling string s and then add one more
 * letter at a random position.
 * 
 * Find the letter that was added in t.
 * 
 * Example:
 * 
 * Input: <br>
 * s = "abcd" <br>
 * t = "abcde" <br>
 * 
 * Output: e
 * 
 * Explanation: 'e' is the letter that was added.
 * 
 * @author zhoudong
 *
 */
public class FindTheDifference {

	public class Bit_Solution {
		public char findTheDifference(String s, String t) {
			int bit1 = createBit(s);
			int bit2 = createBit(t);
			for (int i = 0; i < 32; i++) {
				if (equals(bit1, bit2, i)) {
					return Character.toChars(i + 'a')[0];
				}
			}
			return ' ';
		}

		private boolean equals(int bit1, int bit2, int index) {
			return equals(bit1, bit2, index, index);
		}

		private boolean equals(int bit1, int bit2, int index1, int index2) {
			return isOne(bit1, index1) != isOne(bit2, index2);
		}

		private int createBit(String str) {
			int bit = 0;
			for (char c : str.toCharArray())
				bit = turnOver(bit, c - 'a');
			return bit;
		}

		private int turnOver(int bit, int index) {
			return isOne(bit, index) ? oneToZero(bit, index) : zeroToOne(bit, index);
		}

		private int oneToZero(int bit, int index) {
			int mask = ~(1 << index);
			return mask & bit;
		}

		private int zeroToOne(int bit, int index) {
			int mask = 1 << index;
			return mask | bit;
		}

		private boolean isOne(int bit, int index) {
			int mask = 1 << index;
			return (mask & bit) != 0;
		}
	}

	public class Array_Solution {
		public char findTheDifference(String s, String t) {
			int[] counter = new int[26];
			for (char c : s.toCharArray()) {
				counter[c - 'a']++;
			}
			for (char c : t.toCharArray()) {
				if (--counter[c - 'a'] < 0)
					return c;
			}
			return ' ';
		}
	}
}
