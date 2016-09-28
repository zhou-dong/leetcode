package org.dzhou.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode" return 0.
 * 
 * s = "loveleetcode", return 2.
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 * @author zhoudong
 *
 */
public class FirstUniqueCharacterInAString {

	public class Array_Solution {
		public int firstUniqChar(String s) {
			int[] counter = new int[26];
			for (char c : s.toCharArray()) {
				counter[c - 'a']++;
			}
			for (int i = 0; i < s.length(); i++) {
				if (counter[s.charAt(i) - 'a'] == 1) {
					return i;
				}
			}
			return -1;
		}
	}

	public int Hash_Map_firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}

}
