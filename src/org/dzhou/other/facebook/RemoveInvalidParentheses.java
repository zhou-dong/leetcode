package org.dzhou.other.facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 301. Remove Invalid Parentheses
 * 
 * Remove the minimum number of invalid parentheses in order to make the input
 * string valid. Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses (and).
 * 
 * Examples: <br>
 * "()())()" -> ["()()()", "(())()"] <br>
 * "(a)())()" -> ["(a)()()", "(a())()"] <br>
 * ")(" -> [""] <br>
 * 
 * @author zhoudong
 *
 */
public class RemoveInvalidParentheses {

	public List<String> removeInvalidParentheses(String s) {
		if (s == null) {
			return Collections.emptyList();
		}

		List<String> result = new ArrayList<>();
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();

		queue.add(s);
		visited.add(s);

		boolean found = false;

		while (!queue.isEmpty()) {
			String current = queue.poll();

			if (isValid(current)) {
				result.add(current);
				found = true;
			}

			if (found) {
				continue;
			}

			for (int i = 0; i < current.length(); i++) {
				if (current.charAt(i) != '(' && current.charAt(i) != ')') {
					continue;
				}
				String next = current.substring(0, i) + current.substring(i + 1);
				if (!visited.contains(next)) {
					queue.add(next);
					visited.add(next);
				}
			}
		}
		return result;
	}

	private boolean isValid(String s) {
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				count++;
			} else if (c == ')' && --count < 0) {
				return false;
			}
		}
		return count == 0;
	}

}
