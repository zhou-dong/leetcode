package org.dzhou.leetcode;

/**
 * 110. Balanced Binary Tree
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author zhoudong
 *
 */
public class BalancedBinaryTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Brute_Force_Solution {
		public boolean isBalanced(TreeNode root) {
			if (root == null)
				return true;
			int left = height(root.left);
			int right = height(root.right);
			if (Math.abs(left - right) > 1)
				return false;
			return isBalanced(root.left) && isBalanced(root.right);
		}

		private int height(TreeNode root) {
			if (root == null)
				return 0;
			int left = height(root.left);
			int right = height(root.right);
			return Math.max(left, right) + 1;
		}
	}

	public class Solution {
		public boolean isBalanced(TreeNode root) {
			return height(root) != -1;
		}

		private int height(TreeNode root) {
			if (root == null)
				return 0;
			int left = height(root.left);
			if (left == -1)
				return -1;
			int right = height(root.right);
			if (right == -1)
				return -1;
			if (Math.abs(left - right) > 1)
				return -1;
			return Math.max(left, right) + 1;
		}
	}
}
