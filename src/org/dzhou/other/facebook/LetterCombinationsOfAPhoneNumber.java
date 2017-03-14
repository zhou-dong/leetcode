package org.dzhou.other.facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * 
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * Tags: Backtracking
 * 
 * @author zhoudong
 *
 */
public class LetterCombinationsOfAPhoneNumber {

	String[] buttons = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0)
			return Collections.emptyList();
		List<String> result = new ArrayList<String>();
		dfs(result, buttons, digits, new StringBuilder());
		return result;
	}

	private void dfs(List<String> result, String[] buttons, String digits, StringBuilder item) {
		if (digits.length() == 0) {
			result.add(item.toString());
			return;
		}
		String button = buttons[digits.charAt(0) - '0'];
		for (char ch : button.toCharArray()) {
			item.append(ch);
			dfs(result, buttons, digits.substring(1), item);
			item.deleteCharAt(item.length() - 1);
		}
	}

}
