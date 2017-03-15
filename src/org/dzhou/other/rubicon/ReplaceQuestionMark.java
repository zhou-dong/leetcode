package org.dzhou.other.rubicon;

import java.util.HashSet;
import java.util.Set;

public class ReplaceQuestionMark {

	public Set<String> combinations(String pattern) {
		Set<String> result = new HashSet<>();
		helper(result, pattern, 0, "");
		return result;
	}

	private void helper(Set<String> result, String pattern, int index, String item) {
		if (index == pattern.length()) {
			result.add(item.toString());
			return;
		}
		char ch = pattern.charAt(index);
		if (ch != '?') {
			helper(result, pattern, index + 1, item + ch);
		} else {
			helper(result, pattern, index + 1, item + '0');
			helper(result, pattern, index + 1, item + '1');
		}
	}

}
