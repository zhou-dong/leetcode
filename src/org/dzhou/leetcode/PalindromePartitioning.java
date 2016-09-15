package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * 
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [<br>
 * ["a","a","b"]<br>
 * ["aa","b"],<br>
 * ]<br>
 * *
 * 
 * @author zhoudong
 *
 */
public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
		if (s == null || s.length() == 0)
			return Collections.emptyList();
		List<List<String>> result = new ArrayList<>();
		dfs(result, new ArrayList<>(), s, 0);
		return result;
	}

	private void dfs(List<List<String>> result, List<String> path, String s, int pos) {
		if (pos == s.length()) {
			result.add(new ArrayList<String>(path));
			return;
		}
		for (int i = pos + 1; i <= s.length(); i++) {
			String prefix = s.substring(pos, i);
			if (!isPalindrome(prefix))
				continue;
			path.add(prefix);
			dfs(result, path, s, i);
			path.remove(path.size() - 1);
		}
	}

	private boolean isPalindrome(String s) {
		for (int low = 0, high = s.length() - 1; low < high; low++, high--) {
			if (s.charAt(low) != s.charAt(high)) {
				return false;
			}
		}
		return true;
	}

}
