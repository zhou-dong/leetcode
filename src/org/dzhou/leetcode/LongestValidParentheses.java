package org.dzhou.leetcode;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 * 
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 * @author zhoudong
 *
 */
public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		if (s == null || s.length() < 2)
			return 0;

		Stack<Integer> stack = new Stack<>();
		int start = -1, max = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					start = i;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						max = Math.max(max, i - start);
					} else {
						max = Math.max(max, i - stack.peek());
					}
				}
			}
		}

		return max;
	}

}
