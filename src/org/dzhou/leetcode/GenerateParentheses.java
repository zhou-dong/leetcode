package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 22. Generate Parentheses
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * @author zhoudong
 *
 */
public class GenerateParentheses {

	public class Solution {
		public List<String> generateParenthesis(int n) {
			if (n < 1)
				return Collections.emptyList();
			List<String> result = new ArrayList<>();
			helper(result, new StringBuilder(), n, n);
			return result;
		}

		private void helper(List<String> result, StringBuilder item, int left, int right) {
			if (left > right)
				return;
			if (left == 0 && right == 0) {
				result.add(item.toString());
				return;
			}
			if (left > 0) {
				helper(result, item.append("("), left - 1, right);
				item.deleteCharAt(item.length() - 1);
			}
			if (right > 0) {
				helper(result, item.append(")"), left, right - 1);
				item.deleteCharAt(item.length() - 1);
			}
		}
	}

	public class Solution1 {
		public List<String> generateParenthesis(int n) {
			if (n < 1) {
				return Collections.emptyList();
			}
			List<String> result = new ArrayList<>();
			helper(result, "", n, n);
			return result;
		}

		private void helper(List<String> result, String item, int left, int right) {
			if (left > right) {
				return;
			}
			if (left == 0 && right == 0) {
				result.add(item);
				return;
			}
			if (left > 0) {
				helper(result, item + "(", left - 1, right);
			}
			if (right > 0) {
				helper(result, item + ")", left, right - 1);
			}
		}
	}
}
