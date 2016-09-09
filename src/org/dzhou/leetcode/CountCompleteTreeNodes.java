package org.dzhou.leetcode;

/**
 * 222. Count Complete Tree Nodes
 * 
 * Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia: In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 * 
 * @author zhoudong
 *
 */
public class CountCompleteTreeNodes {

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
		public int countNodes(TreeNode root) {
			if (null == root)
				return 0;
			int left = getLeftHeight(root);
			int right = getRightHeight(root);
			return (left == right) ? count(left) : (countNodes(root.left) + countNodes(root.right) + 1);
		}

		private int count(int height) {
			// return (int) Math.pow(2, leftHeight) - 1;
			return (2 << (height - 1)) - 1;
		}

		private int getLeftHeight(TreeNode root) {
			int height = 0;
			while (root != null) {
				height++;
				root = root.left;
			}
			return height;
		}

		private int getRightHeight(TreeNode root) {
			int height = 0;
			while (root != null) {
				height++;
				root = root.right;
			}
			return height;
		}
	}
}
