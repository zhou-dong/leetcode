package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 107. Binary Tree Level Order Traversal II
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example: Given binary tree [3,9,20,null,null,15,7],
 * 
 * @author zhoudong
 *
 */
public class BinaryTreeLevelOrderTraversalII {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class DFS_Solution {
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			int height = height(root);
			List<List<Integer>> result = createList(height + 1);
			dfs(root, result, height);
			return result;
		}

		private void dfs(TreeNode root, List<List<Integer>> result, int height) {
			if (root == null)
				return;
			dfs(root.left, result, height - 1);
			result.get(height).add(root.val);
			dfs(root.right, result, height - 1);
		}

		private int height(TreeNode root) {
			if (root == null)
				return -1;
			int left = height(root.left);
			int right = height(root.right);
			return Math.max(left, right) + 1;
		}

		private List<List<Integer>> createList(int size) {
			List<List<Integer>> result = new ArrayList<>();
			for (int i = 0; i < size; i++)
				result.add(new ArrayList<>());
			return result;
		}
	}

	public class BFS_Solution {
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			if (root == null)
				return Collections.emptyList();

			Stack<List<Integer>> stack = new Stack<>();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				int size = queue.size();
				List<Integer> item = new ArrayList<>();
				for (int i = 0; i < size; i++) {
					TreeNode current = queue.poll();
					item.add(current.val);
					if (current.left != null) {
						queue.add(current.left);
					}
					if (current.right != null) {
						queue.add(current.right);
					}
				}
				stack.add(item);
			}
			return stackToList(stack);
		}

		private List<List<Integer>> stackToList(Stack<List<Integer>> stack) {
			List<List<Integer>> result = new ArrayList<>();
			while (!stack.isEmpty())
				result.add(stack.pop());
			return result;
		}
	}
}
