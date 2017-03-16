package org.dzhou.other.facebook;

import java.util.ArrayList;
import java.util.List;

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

	class Inorder_Solution {

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

		private void inorder(TreeNode node, List<Integer> nums) {
			if (node != null) {
				inorder(node.left, nums);
				nums.add(node.val);
				inorder(node.right, nums);
			}
		}

	}

	class Definition_Solution {

		public boolean isValidBST(TreeNode root) {
			return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
		}

		private boolean isValidBST(TreeNode root, long min, long max) {
			if (root == null)
				return true;
			if (root.val <= min || root.val >= max)
				return false;
			return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
		}

	}

}
