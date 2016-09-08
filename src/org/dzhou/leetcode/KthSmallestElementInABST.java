package org.dzhou.leetcode;

import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up: What if the BST is modified (insert/delete operations) often and
 * you need to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 * 
 * Hint:
 * 
 * Try to utilize the property of a BST.
 * 
 * What if you could modify the BST node's structure?
 * 
 * The optimal runtime complexity is O(height of BST).
 * 
 * @author zhoudong
 *
 */
public class KthSmallestElementInABST {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class DFS_Solution {
		int count = 0;
		int value = 0;

		public int kthSmallest(TreeNode root, int k) {
			count = k;
			value = -1;
			inOrder(root);
			return value;
		}

		private void inOrder(TreeNode root) {
			if (root == null)
				return;
			inOrder(root.left);
			if (--count == 0) {
				value = root.val;
				return;
			}
			inOrder(root.right);
		}
	}

	public class BFS_Solution {
		public int kthSmallest(TreeNode root, int k) {
			if (root == null)
				return -1;
			Stack<TreeNode> stack = new Stack<>();
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			while (k != 0 && !stack.isEmpty()) {
				TreeNode node = stack.pop();
				if (--k == 0)
					return node.val;
				TreeNode right = node.right;
				while (right != null) {
					stack.push(right);
					right = right.left;
				}
			}
			return -1;
		}
	}

}
