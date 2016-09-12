package org.dzhou.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 20. Valid Parentheses
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author zhoudong
 *
 */
public class ValidParentheses {

	public static class Solution {

		static Set<Character> set = new HashSet<>();
		static Map<Character, Character> map = new HashMap<>();

		static {
			set.add('(');
			set.add('{');
			set.add('[');
			map.put('(', ')');
		}

		public boolean isValid(String s) {

			return true;
		}
	}
}
