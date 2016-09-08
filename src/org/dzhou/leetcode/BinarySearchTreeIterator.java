package org.dzhou.leetcode;

import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * @author zhoudong
 *
 */
public class BinarySearchTreeIterator {

	// Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class BSTIterator {
		Stack<TreeNode> stack = null;

		public BSTIterator(TreeNode root) {
			stack = new Stack<>();
			while (root != null) {
				stack.add(root);
				root = root.left;
			}
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		/** @return the next smallest number */
		public int next() {
			TreeNode current = stack.pop();
			int value = current.val;
			current = current.right;
			while (current != null) {
				stack.add(current);
				current = current.left;
			}
			return value;
		}
	}

	// Your BSTIterator will be called like this:
	// BSTIterator i = new BSTIterator(root);
	// while (i.hasNext()) v[f()] = i.next();
}
