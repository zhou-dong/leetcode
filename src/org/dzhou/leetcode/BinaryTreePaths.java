package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 257. Binary Tree Paths
 * 
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 
 * @author zhoudong
 *
 */
public class BinaryTreePaths {

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
		public List<String> binaryTreePaths(TreeNode root) {
			if (root == null)
				return Collections.emptyList();
			List<String> result = new ArrayList<>();
			dfs(root, result, root.val + "");
			return result;
		}

		private void dfs(TreeNode root, List<String> result, String item) {
			if (root.left == null && root.right == null)
				result.add(item);
			if (root.left != null)
				dfs(root.left, result, item + "->" + root.left.val);
			if (root.right != null)
				dfs(root.right, result, item + "->" + root.right.val);
		}
	}

	public class Iterator_Solution {
		public List<String> binaryTreePaths(TreeNode root) {
			if (root == null)
				return Collections.emptyList();
			List<String> result = new ArrayList<>();
			Queue<TreeNode> nodes = new LinkedList<>();
			Queue<String> values = new LinkedList<>();
			nodes.add(root);
			values.add(String.valueOf(root.val));
			while (!nodes.isEmpty()) {
				TreeNode node = nodes.poll();
				String value = values.poll();
				if (node.left == null && node.right == null) {
					result.add(value);
				}
				if (node.left != null) {
					nodes.add(node.left);
					values.add(value + "->" + node.left.val);
				}
				if (node.right != null) {
					nodes.add(node.right);
					values.add(value + "->" + node.right.val);
				}
			}
			return result;
		}
	}

}
