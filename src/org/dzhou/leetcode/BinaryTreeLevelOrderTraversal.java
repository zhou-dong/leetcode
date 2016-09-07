package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * 
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * For example: Given binary tree [3,9,20,null,null,15,7],
 * 
 * @author zhoudong
 *
 */
public class BinaryTreeLevelOrderTraversal {

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
		public List<List<Integer>> levelOrder(TreeNode root) {
			List<List<Integer>> result = new ArrayList<>();
			dfs(root, result, 0);
			return result;

		}

		private void dfs(TreeNode root, List<List<Integer>> result, int index) {
			if (root == null)
				return;
			if (result.size() == index)
				result.add(new ArrayList<>());
			result.get(index).add(root.val);
			dfs(root.left, result, index + 1);
			dfs(root.right, result, index + 1);
		}
	}

	public class BFS_Solution {
		public List<List<Integer>> levelOrder(TreeNode root) {
			if (root == null)
				return Collections.emptyList();

			List<List<Integer>> result = new ArrayList<>();
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
				result.add(item);
			}
			return result;

		}
	}

}
