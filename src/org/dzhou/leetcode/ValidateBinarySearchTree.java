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

	public class Inorder_Solution {
		TreeNode previous = null;
		boolean isValid = true;

		public boolean isValidBST(TreeNode root) {
			init();
			inOrder(root);
			return isValid;

		}

		private void inOrder(TreeNode root) {
			if (root == null)
				return;
			inOrder(root.left);
			if (previous != null && root.val <= previous.val) {
				isValid = false;
				return;
			}
			previous = root;
			inOrder(root.right);
		}

		private void init() {
			previous = null;
			isValid = true;
		}
	}

	public class Inorder_Solution2 {
		double previous = 0d;
		boolean isValid = true;

		public boolean isValidBST(TreeNode root) {
			init();
			inOrder(root);
			return isValid;

		}

		private void inOrder(TreeNode root) {
			if (root == null)
				return;
			inOrder(root.left);
			if (root.val <= previous) {
				isValid = false;
				return;
			}
			previous = root.val;
			inOrder(root.right);
		}

		private void init() {
			previous = Double.NEGATIVE_INFINITY;
			isValid = true;
		}
	}

}
