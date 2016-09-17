package org.dzhou.leetcode;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

/**
 * 140. Word Break II
 * 
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * 
 * s = "catsanddog",<br>
 * dict = ["cat", "cats", "and", "sand", "dog"].<br>
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * @author zhoudong
 *
 */
public class WordBreakII {

	static private int getDuration(String duration) {
		String[] times = duration.split(":");
		int result = 0;
		for (int i = 0; i < 3; i++) {
			result *= 60;
			result += Integer.parseInt(times[i]);
		}
		return result;
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(getDuration("00:01:07"));
		System.out.println(getDuration("00:05:00"));
		System.out.println(getDuration("01:05:00"));
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		return null;
	}
}
