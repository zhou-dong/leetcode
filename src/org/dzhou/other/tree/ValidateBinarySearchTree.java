package org.dzhou.other.tree;

import java.util.ArrayList;
import java.util.List;

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

	public class Definition_Solution {
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

	public class Inorder_Array_Solution {

		public boolean isValidBST(TreeNode root) {
			List<Integer> nums = new ArrayList<>();
			inorder(root, nums);
			for (int i = 0; i < nums.size() - 1; i++) {
				if (nums.get(i) >= nums.get(i + 1)) {
					return false;
				}
			}
			return true;
		}

		private void inorder(TreeNode root, List<Integer> list) {
			if (root == null)
				return;
			inorder(root.left, list);
			list.add(root.val);
			inorder(root.right, list);
		}

	}

	public class Inorder_Solution {
		double previous = 0d;
		boolean isValid = true;

		public boolean isValidBST(TreeNode root) {
			init();
			inOrder(root);
			return isValid;

		}

		private void init() {
			previous = Double.NEGATIVE_INFINITY;
			isValid = true;
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
	}
}
