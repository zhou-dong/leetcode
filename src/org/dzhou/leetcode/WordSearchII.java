package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 212. Word Search II
 * 
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * For example, Given words = ["oath","pea","eat","rain"] and board =
 * 
 * [ <br>
 * --['o','a','a','n'], <br>
 * --['e','t','a','e'], <br>
 * --['i','h','k','r'], <br>
 * --['i','f','l','v'] <br>
 * ] <br>
 * 
 * Return ["eat","oath"].
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * @author zhoudong
 *
 */
public class WordSearchII {

	class TrieNode {
		boolean isWord;
		Map<Character, TrieNode> children;

		TrieNode() {
			isWord = false;
			children = new HashMap<>();
		}

		public TrieNode addChild(char c) {
			if (!children.containsKey(c))
				children.put(c, new TrieNode());
			return children.get(c);
		}

		public boolean contains(char c) {
			return children.containsKey(c);
		}

		public TrieNode getChild(char c) {
			if (!children.containsKey(c))
				return null;
			return children.get(c);
		}
	}

	class Trie {
		TrieNode root = null;

		public Trie() {
			root = new TrieNode();
		}

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

		public boolean isWord(String str) {
			TrieNode node = searchNode(str);
			return node == null ? false : node.isWord;
		}

		public boolean startWith(String str) {
			return searchNode(str) != null;
		}

		private TrieNode searchNode(String str) {
			if (str == null || str.length() == 0)
				return null;
			return searchNode(str, root);
		}

		private TrieNode searchNode(String str, TrieNode node) {
			for (char c : str.toCharArray()) {
				if (!node.contains(c))
					return null;
				node = node.getChild(c);
			}
			return node;
		}
	}

	char[][] board = null;
	boolean[][] visited = null;
	Set<String> set = null;
	Trie trie = null;

	public List<String> findWords(char[][] board, String[] words) {
		this.board = board;
		visited = new boolean[board.length][board[0].length];
		set = new HashSet<>();
		initTrie(words);
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				dfs(row, col, "");
			}
		}
		return new ArrayList<>(set);
	}

	private void initTrie(String[] words) {
		trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}
	}

	private void dfs(int row, int col, String item) {
		if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || visited[row][col])
			return;

		item += board[row][col];

		if (!trie.startWith(item)) {
			return;
		}

		if (trie.isWord(item)) {
			set.add(item);
		}

		visited[row][col] = true;
		dfs(row - 1, col, item);
		dfs(row + 1, col, item);
		dfs(row, col - 1, item);
		dfs(row, col + 1, item);
		visited[row][col] = false;
	}

}
