package org.dzhou.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 208. Implement Trie (Prefix Tree) QuestionEditorial Solution My Submissions
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @author zhoudong
 *
 */
public class ImplementTriePrefixTree {

	class TrieNode {
		boolean isWord;
		Map<Character, TrieNode> children;

		// Initialize your data structure here.
		public TrieNode() {
			isWord = false;
			children = new HashMap<>();
		}

		public boolean contains(char c) {
			return children.containsKey(c);
		}

		public TrieNode addChild(char c) {
			if (!children.containsKey(c))
				children.put(c, new TrieNode());
			return children.get(c);
		}

		public TrieNode getChild(char c) {
			if (!children.containsKey(c))
				return null;
			return children.get(c);
		}
	}

	public class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			if (word == null || word.length() == 0)
				return;
			insert(word, root);
		}

		private void insert(String word, TrieNode node) {
			for (char c : word.toCharArray())
				node = node.addChild(c);
			node.isWord = true;
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			TrieNode node = searchNode(word);
			return node == null ? false : node.isWord;
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			return searchNode(prefix) != null;
		}

		public TrieNode searchNode(String str) {
			if (str == null || str.length() == 0)
				return null;
			return searchNode(str, root);
		}

		private TrieNode searchNode(String str, TrieNode current) {
			for (char c : str.toCharArray()) {
				if (!current.contains(c))
					return null;
				current = current.getChild(c);
			}
			return current;
		}
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");

}