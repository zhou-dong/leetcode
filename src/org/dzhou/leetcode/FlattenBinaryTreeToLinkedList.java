package org.dzhou.leetcode;

/**
 * 114. Flatten Binary Tree to Linked List
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * @author zhoudong
 *
 */
public class FlattenBinaryTreeToLinkedList {

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

		TreeNode prev = null;

		public void flatten(TreeNode root) {

			if (root == null)
				return;

			if (prev != null) {
				prev.left = null;
				prev.right = root;
			}

			prev = root;

			TreeNode right = root.right;
			flatten(root.left);
			flatten(right);
		}

	}

}
