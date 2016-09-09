package org.dzhou.leetcode;

/**
 * 124. Binary Tree Maximum Path Sum
 * 
 * Given a binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path does not need to go through the root.
 * 
 * @author zhoudong
 *
 */
public class BinaryTreeMaximumPathSum {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Solution {
		int max = Integer.MIN_VALUE;

		public int maxPathSum(TreeNode root) {
			traversal(root);
			return max;
		}

		private int traversal(TreeNode root) {
			if (root == null)
				return 0;
			int left = traversal(root.left);
			int right = traversal(root.right);
			int path = Math.max(root.val + left, root.val + right);
			max = Math.max(max, left + root.val + right);
			return path > 0 ? path : 0;
		}
	}

	public class Solution1 {
		int max = Integer.MIN_VALUE;

		public int maxPathSum(TreeNode root) {
			traversal(root);
			return max;
		}

		public int traversal(TreeNode root) {
			if (root == null)
				return 0;
			int left = traversal(root.left);
			int right = traversal(root.right);
			int path = Math.max(root.val, Math.max(root.val + left, root.val + right));
			max = Math.max(max, Math.max(path, left + root.val + right));
			return path;
		}
	}

}
