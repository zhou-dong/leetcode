package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author zhoudong
 *
 */
public class BinaryTreeInorderTraversal {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Iterative_Solution {
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			Stack<TreeNode> stack = new Stack<>();
			addLeftToStack(root, stack);
			addToResult(stack, result);
			return result;
		}

		private void addToResult(Stack<TreeNode> stack, List<Integer> result) {
			if (stack.isEmpty())
				return;
			TreeNode node = stack.pop();
			result.add(node.val);
			addLeftToStack(node.right, stack);
			addToResult(stack, result);
		}

		private void addLeftToStack(TreeNode root, Stack<TreeNode> stack) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}
		}
	}

	public class Recursive_Solution {
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			inOrder(root, result);
			return result;
		}

		private void inOrder(TreeNode root, List<Integer> result) {
			if (root == null)
				return;
			inOrder(root.left, result);
			result.add(root.val);
			inOrder(root.right, result);
		}
	}
}
