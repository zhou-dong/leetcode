package org.dzhou.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * Tags: Two Pointers, Hash Table, String
 * 
 * @author zhoudong
 *
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;

		Set<Character> set = new HashSet<>();

		int max = 0, left = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!set.contains(c)) {
				set.add(c);
				max = Math.max(max, set.size());
			} else {
				while (set.contains(c))
					set.remove(s.charAt(left++));
				set.add(c);
			}
		}

		return max;
	}

}
