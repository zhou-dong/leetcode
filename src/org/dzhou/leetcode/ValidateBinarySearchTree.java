package org.dzhou.leetcode;

/**
 * 98. Validate Binary Search Tree
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * @author zhoudong
 *
 */
public class ValidateBinarySearchTree {

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

		public boolean isValidBST(TreeNode root) {
			return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		}

		private boolean isValidBST(TreeNode root, double min, double max) {
			if (root == null)
				return true;
			if (root.val <= min || root.val >= max)
				return false;
			return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
		}

	}

}
