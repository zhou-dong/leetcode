package org.dzhou.leetcode;

/**
 * 333. Largest BST Subtree
 * 
 * Given a binary tree, find the largest subtree which is a Binary Search Tree
 * (BST), where largest means subtree with largest number of nodes in it.
 * 
 * Note: A subtree must include all of its descendants. Here's an example:
 * 
 * @author zhoudong
 *
 */
public class LargestBstSubtree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Down_Top_Solution {

	}

	public class Top_Down_Solution {
		public int largestBSTSubtree(TreeNode root) {
			if (root == null)
				return 0;
			if (isValidBST(root)) {
				return height(root);
			}
			int left = largestBSTSubtree(root.left);
			int right = largestBSTSubtree(root.right);
			return Math.max(left, right);
		}

		private boolean isValidBST(TreeNode node) {
			return isValidBST(node, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		}

		private boolean isValidBST(TreeNode node, double min, double max) {
			if (node == null)
				return true;
			if (node.val <= min || node.val >= max)
				return false;
			return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
		}

		private int height(TreeNode node) {
			if (node == null)
				return 0;
			int left = height(node.left);
			int right = height(node.right);
			return Math.max(left, right) + 1;
		}
	}

}
