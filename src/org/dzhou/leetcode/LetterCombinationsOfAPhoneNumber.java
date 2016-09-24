package org.dzhou.leetcode;

import java.util.ArrayList;
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
 * Input:Digit string "23"
 * 
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Note: Although the above answer is in lexicographical order, your answer
 * could be in any order you want.
 * 
 * @author zhoudong
 *
 */
public class LetterCombinationsOfAPhoneNumber {

	public List<String> letterCombinations(String digits) {
		String[] buttons = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		List<String> result = new ArrayList<String>();
		dfs(result, digits.length(), buttons, digits, new StringBuffer());
		return result;
	}

	private void dfs(List<String> result, int remain, String[] buttons, String digits, StringBuffer sb) {
		if (remain == 0) {
			if (sb.length() != 0)
				result.add(sb.toString());
			return;
		}
		String button = buttons[digits.charAt(0) - '0'];
		for (int i = 0; i < button.length(); i++) {
			sb = sb.append(button.charAt(i));
			dfs(result, remain - 1, buttons, digits.substring(1), sb);
			sb.deleteCharAt(sb.length() - 1); // 恢复现场
		}
	}
	
}
