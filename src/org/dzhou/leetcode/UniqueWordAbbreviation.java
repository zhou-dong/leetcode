package org.dzhou.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 288. Unique Word Abbreviation
 * 
 * @author zhoudong
 *
 */
public class UniqueWordAbbreviation {

	public class ValidWordAbbr {

		Map<String, Set<String>> map = null;

		public ValidWordAbbr(String[] dictionary) {
			map = new HashMap<>();
			for (String word : dictionary) {
				String abbr = wordAbbr(word);
				if (!map.containsKey(abbr))
					map.put(abbr, new HashSet<>());
				map.get(abbr).add(word);
			}
		}

		public boolean isUnique(String word) {
			String abbr = wordAbbr(word);
			if (!map.containsKey(abbr))
				return true;
			Set<String> set = map.get(abbr);
			return set.size() == 1 && set.contains(word);
		}

		private String wordAbbr(String word) {
			if (word.length() < 3)
				return word;
			StringBuilder sb = new StringBuilder();
			sb.append(word.charAt(0));
			sb.append(word.length() - 2);
			sb.append(word.charAt(word.length() - 1));
			return sb.toString();
		}
	}

	// Your ValidWordAbbr object will be instantiated and called as such:
	// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
	// vwa.isUnique("Word");
	// vwa.isUnique("anotherWord");
}
