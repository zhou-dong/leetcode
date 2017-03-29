package org.dzhou.leetcode;

/**
 * 543. Diameter of Binary Tree
 * 
 * Given a binary tree, you need to compute the length of the diameter of the
 * tree. The diameter of a binary tree is the length of the longest path between
 * any two nodes in a tree. This path may or may not pass through the root.
 * 
 * @author zhoudong
 *
 */
public class DiameterOfBinaryTree {

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
		int max = 0;

		public int diameterOfBinaryTree(TreeNode root) {
			maxDepth(root);
			return max;
		}

		private int maxDepth(TreeNode root) {
			if (root == null)
				return 0;
			int left = maxDepth(root.left);
			int right = maxDepth(root.right);
			max = Math.max(max, left + right);
			return Math.max(left, right) + 1;
		}

	}

	public class solution1 {

		int max = 0;

		public int diameterOfBinaryTree(TreeNode root) {
			maxDepth(root);
			return max;
		}

		private int maxDepth(TreeNode root) {
			if (root == null)
				return 0;
			int left = maxDepth(root.left);
			int right = maxDepth(root.right);
			max = Math.max(max, left + right);
			return Math.max(left, right) + 1;
		}
	}
}
