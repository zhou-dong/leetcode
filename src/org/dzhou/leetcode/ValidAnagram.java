package org.dzhou.leetcode;

import java.util.Arrays;

/**
 * 242. Valid Anagram
 * 
 * @author zhoudong
 *
 */
public class ValidAnagram {

	public class Sorted_Solution {
		public boolean isAnagram(String s, String t) {
			if (s.length() != t.length())
				return false;
			char[] x = s.toCharArray();
			char[] y = t.toCharArray();
			Arrays.sort(x);
			Arrays.sort(y);
			return Arrays.equals(x, y);
		}
	}

	public class Array_Solution {
		public boolean isAnagram(String s, String t) {
			if (s.length() != t.length()) {
				return false;
			}
			int[] counter = new int[26];
			for (int i = 0; i < s.length(); i++) {
				counter[s.charAt(i) - 'a']++;
				counter[t.charAt(i) - 'a']--;
			}
			for (int count : counter) {
				if (count != 0) {
					return false;
				}
			}
			return true;
		}
	}

	public class Array_Solution2 {
		public boolean isAnagram(String s, String t) {
			if (s.length() != t.length()) {
				return false;
			}
			int[] table = new int[26];
			for (int i = 0; i < s.length(); i++) {
				table[s.charAt(i) - 'a']++;
			}
			for (int i = 0; i < t.length(); i++) {
				if (--table[t.charAt(i) - 'a'] < 0) {
					return false;
				}
			}
			return true;
		}
	}

}
