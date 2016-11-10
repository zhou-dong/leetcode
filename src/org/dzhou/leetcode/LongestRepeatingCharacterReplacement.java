package org.dzhou.leetcode;

/**
 * 424. Longest Repeating Character Replacement
 * 
 * Difficulty: Medium
 * 
 * Given a string that consists of only uppercase English letters, you can
 * replace any letter in the string with another letter at most k times. Find
 * the length of a longest substring containing all repeating letters you can
 * get after performing the above operations.
 * 
 * Note: Both the string's length and k will not exceed 104.
 * 
 * Example 1:
 * 
 * Input: s = "ABAB", k = 2
 * 
 * Output: 4
 * 
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * 
 * Example 2:
 * 
 * Input: s = "AABABBA", k = 1
 * 
 * Output: 4
 * 
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * 
 * @author zhoudong
 *
 */
public class LongestRepeatingCharacterReplacement {

	public int characterReplacement(String s, int k) {
		int max = k;
		for (int i = 0; i + k < s.length(); i++)
			max = Math.max(max, longestConsecutive(s, i, k));
		return max;
	}

	private int longestConsecutive(String s, int start, int k) {
		char first = s.charAt(start);
		int count = 0;
		for (int i = start; i < s.length(); i++) {
			char current = s.charAt(i);
			if (first != current && k == 0) {
				return count;
			}
			count++;
			if (first == current) {
				continue;
			} else {
				k--;
			}
		}
		return count;
	}

}
