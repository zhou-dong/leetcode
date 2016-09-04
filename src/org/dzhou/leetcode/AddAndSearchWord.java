package org.dzhou.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 211. Add and Search Word - Data structure design QuestionEditorial Solution
 * My Submissions
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word) <br>
 * bool search(word) <br>
 * 
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one letter.
 * 
 * For example:
 * 
 * addWord("bad") <br>
 * addWord("dad") <br>
 * addWord("mad") <br>
 * search("pad") -> false <br>
 * search("bad") -> true <br>
 * search(".ad") -> true <br>
 * search("b..") -> true <br>
 * 
 * Note: You may assume that all words are consist of lowercase letters a-z.
 * 
 * @author zhoudong
 *
 */
public class AddAndSearchWord {

	public class WordDictionary {
		class TrieNode {
			boolean isWord;
			Map<Character, TrieNode> children;

			TrieNode() {
				this.isWord = false;
				this.children = new HashMap<>();
			}

			boolean contains(char c) {
				return children.containsKey(c);
			}

			TrieNode addChild(char c) {
				if (!children.containsKey(c))
					children.put(c, new TrieNode());
				return children.get(c);
			}

			TrieNode getChild(char c) {
				return children.get(c);
			}
		}

		TrieNode root = null;

		public WordDictionary() {
			root = new TrieNode();
		}

		// Adds a word into the data structure.
		public void addWord(String word) {
			if (word == null || word.length() == 0)
				return;
			TrieNode current = root;
			for (char c : word.toCharArray())
				current = current.addChild(c);
			current.isWord = true;
		}

		// Returns if the word is in the data structure. A word could
		// contain the dot character '.' to represent any one letter.
		public boolean search(String word) {
			return search(word, 0, root);
		}

		private boolean search(String word, int index, TrieNode curr) {
			if (index == word.length())
				return false;
			char c = word.charAt(index);
			if (curr.contains(c)) {
				if (index == word.length() - 1)
					return curr.getChild(c).isWord;
				return search(word, index + 1, curr.getChild(c));
			} else if (c == '.') {
				boolean result = false;
				for (Map.Entry<Character, TrieNode> child : curr.children.entrySet()) {
					if (index == word.length() - 1 && child.getValue().isWord) {
						return true;
					}
					// if any path is true, set result to be true;
					if (search(word, index + 1, child.getValue())) {
						result = true;
					}
				}
				return result;
			} else {
				return false;
			}
		}
	}

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");
}
