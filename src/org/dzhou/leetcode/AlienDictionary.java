package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * 269. Alien Dictionary
 * 
 * There is a new alien language which uses the latin alphabet. However, the
 * order among letters are unknown to you. You receive a list of words from the
 * dictionary, where words are sorted lexicographically by the rules of this new
 * language. Derive the order of letters in this language.
 * 
 * For example, Given the following words in dictionary,
 * 
 * [ <br>
 * --"wrt", <br>
 * --"wrf", <br>
 * --"er", <br>
 * --"ett", <br>
 * --"rftt" <br>
 * ] <br>
 * 
 * The correct order is: "wertf".
 * 
 * Note:<br>
 * 1.You may assume all letters are in lowercase.<br>
 * 2.If the order is invalid, return an empty string.<br>
 * 3.There may be multiple valid order of letters, return any one of them is
 * fine.
 * 
 * @author zhoudong
 *
 */
public class AlienDictionary {

	public class Solution {
		public String alienOrder(String[] words) {
			Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
			Map<Character, Integer> degree = new HashMap<Character, Integer>();
			String result = "";
			if (words == null || words.length == 0)
				return result;
			for (String s : words) {
				for (char c : s.toCharArray()) {
					degree.put(c, 0);
				}
			}
			for (int i = 0; i < words.length - 1; i++) {
				String cur = words[i];
				String next = words[i + 1];
				int length = Math.min(cur.length(), next.length());
				for (int j = 0; j < length; j++) {
					char c1 = cur.charAt(j);
					char c2 = next.charAt(j);
					if (c1 != c2) {
						Set<Character> set = new HashSet<Character>();
						if (map.containsKey(c1))
							set = map.get(c1);
						if (!set.contains(c2)) {
							set.add(c2);
							map.put(c1, set);
							degree.put(c2, degree.get(c2) + 1);
						}
						break;
					}
				}
			}
			Queue<Character> q = new LinkedList<Character>();
			for (char c : degree.keySet()) {
				if (degree.get(c) == 0)
					q.add(c);
			}
			while (!q.isEmpty()) {
				char c = q.remove();
				result += c;
				if (map.containsKey(c)) {
					for (char c2 : map.get(c)) {
						degree.put(c2, degree.get(c2) - 1);
						if (degree.get(c2) == 0)
							q.add(c2);
					}
				}
			}
			if (result.length() != degree.size())
				return "";
			return result;
		}
	}

	class Trie_Topological_Solution {
		class TrieNode {
			Character c;
			Map<Character, Integer> map;
			List<TrieNode> children;

			TrieNode(Character c) {
				this.c = c;
				this.children = new ArrayList<>();
				this.map = new HashMap<>();
			}

			boolean contains(char c) {
				return this.map.containsKey(c);
			}

			TrieNode addChild(char c) {
				if (!map.containsKey(c)) {
					map.put(c, children.size());
					children.add(new TrieNode(c));
				}
				return children.get(map.get(c));
			}
		}

		class Trie {
			TrieNode root;

			Trie() {
				root = new TrieNode(null);
			}

			public void insert(String word) {
				if (word != null && word.length() > 0) {
					insert(word, root);
				}
			}

			private void insert(String word, TrieNode node) {
				for (char c : word.toCharArray()) {
					node = node.addChild(c);
				}
			}
		}

		class TopologicalSort {
			Map<Character, Set<Character>> graph;
			Stack<Character> result;
			Set<Character> visited;
			Set<Character> visiting;
			boolean hasCycle;

			public String sort(Map<Character, Set<Character>> graph) {
				this.hasCycle = false;
				this.graph = graph;
				this.result = new Stack<>();
				this.visited = new HashSet<>();
				this.visiting = new HashSet<>();
				sortWithKahnAlgorithm();
				return resultToString();
			}

			private void sortWithKahnAlgorithm() {
				for (char c : graph.keySet()) {
					if (!visited.contains(c)) {
						dfs(c);
					}
				}
			}

			private void dfs(char c) {
				visiting.add(c);
				if (graph.containsKey(c)) {
					for (char child : graph.get(c)) {
						if (visiting.contains(child)) {
							hasCycle = true;
							return;
						}
						if (!visited.contains(child)) {
							dfs(child);
						}
					}
				}
				visiting.remove(c);
				visited.add(c);
				result.add(c);
			}

			private String resultToString() {
				if (hasCycle)
					return "";
				StringBuilder sb = new StringBuilder();
				while (!result.isEmpty())
					sb.append(result.pop());
				return sb.toString();
			}
		}

		public String alienOrder(String[] words) {
			Trie trie = buildTrie(words);
			Map<Character, Set<Character>> graph = createGraph(trie, words);
			System.out.println(graph);
			return new TopologicalSort().sort(graph);
		}

		private Trie buildTrie(String[] words) {
			Trie trie = new Trie();
			for (String word : words)
				trie.insert(word);
			return trie;
		}

		private Map<Character, Set<Character>> createGraph(Trie trie, String[] words) {
			Map<Character, Set<Character>> graph = new HashMap<>();
			addStarts(words, graph);
			Queue<TrieNode> queue = new LinkedList<>();
			queue.add(trie.root);
			while (!queue.isEmpty()) {
				TrieNode current = queue.poll();
				List<TrieNode> children = current.children;
				for (int i = 0; i < children.size(); i++) {
					queue.add(children.get(i));
					if (i < children.size() - 1) {
						addEdge(graph, children.get(i).c, children.get(i + 1).c);
					}
				}
			}
			return graph;
		}

		private void addStarts(String[] words, Map<Character, Set<Character>> graph) {
			for (String word : words) {
				for (char c : word.toCharArray()) {
					if (!graph.containsKey(c)) {
						graph.put(c, new HashSet<>());
					}
				}
			}
		}

		private void addEdge(Map<Character, Set<Character>> map, char key, char val) {
			if (key == val)
				return;
			if (!map.containsKey(key))
				map.put(key, new HashSet<>());
			map.get(key).add(val);
		}
	}
}
