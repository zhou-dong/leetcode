package org.dzhou.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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

	static Set<Character> set = new HashSet<>();
	static Map<Character, Character> map = new HashMap<>();

	static {
		set.add('(');
		set.add('[');
		set.add('{');
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (set.contains(c)) {
				stack.add(c);
			} else {
				if (stack.isEmpty())
					return false;
				if (stack.pop() != map.get(c))
					return false;
			}
		}

		return stack.size() == 0;
	}

}
