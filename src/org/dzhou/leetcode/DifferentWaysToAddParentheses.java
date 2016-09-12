package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 241. Different Ways to Add Parentheses
 * 
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators. The
 * valid operators are +, - and *.
 * 
 * @author zhoudong
 *
 */
public class DifferentWaysToAddParentheses {

	public List<Integer> diffWaysToCompute(String input) {
		if (input == null || input.length() == 0)
			return Collections.emptyList();
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (!isOperator(c))
				continue;

			List<Integer> partial1 = diffWaysToCompute(input.substring(0, i));
			List<Integer> partial2 = diffWaysToCompute(input.substring(i + 1, input.length()));

			for (int x : partial1) {
				for (int y : partial2) {
					result.add(calculate(x, y, c));
				}
			}
		}

		if (result.size() == 0) {
			result.add(Integer.parseInt(input));
		}
		return result;
	}

	private boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*';
	}

	private int calculate(int x, int y, char operator) {
		switch (operator) {
		case '+':
			return x + y;
		case '-':
			return x - y;
		case '*':
			return x * y;
		}
		return 0;
	}
}
