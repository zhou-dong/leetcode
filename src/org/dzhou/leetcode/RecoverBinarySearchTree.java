package org.dzhou.leetcode;

/**
 * 99. Recover Binary Search Tree
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note:
 * 
 * A solution using O(n) space is pretty straight forward. Could you devise a
 * constant space solution?
 * 
 * @author zhoudong
 *
 */
public class RecoverBinarySearchTree {

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

		TreeNode first = null, second = null, previous = null;

		public void recoverTree(TreeNode root) {
			first = null;
			second = null;
			previous = null;
			inOrderTraversal(root);
			swap();
		}

		// example: 1,4,3,2,5,6
		// _result: 1,2,3,4,5,6
		private void inOrderTraversal(TreeNode node) {
			if (node == null)
				return;
			inOrderTraversal(node.left);
			if (previous != null && node.val < previous.val) {
				if (first == null)
					first = previous;
				second = node;
			}
			previous = node;
			inOrderTraversal(node.right);
		}

		private void swap() {
			if (first != null && second != null) {
				swap(first, second);
			}
		}

		private void swap(TreeNode node1, TreeNode node2) {
			int temp = node1.val;
			node1.val = node2.val;
			node2.val = temp;
		}

	}

}
