package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author zhoudong
 *
 */
public class BinaryTreePreorderTraversal {

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
		public List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			Stack<TreeNode> stack = new Stack<>();
			while (root != null || !stack.isEmpty()) {
				if (root != null) {
					result.add(root.val);
					stack.add(root);
					root = root.left;
				} else {
					root = stack.pop();
					root = root.right;
				}
			}
			return result;
		}
	}

	public class Iterative_Recursive_Solution {
		public List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			Stack<TreeNode> stack = new Stack<>();
			addToStack(root, stack, result);
			popFromStack(stack, result);
			return result;
		}

		private void popFromStack(Stack<TreeNode> stack, List<Integer> result) {
			if (stack.isEmpty()) {
				return;
			}
			TreeNode node = stack.pop();
			addToStack(node.right, stack, result);
			popFromStack(stack, result);
		}

		private void addToStack(TreeNode root, Stack<TreeNode> stack, List<Integer> result) {
			while (root != null) {
				result.add(root.val);
				stack.add(root);
				root = root.left;
			}
		}
	}

	public class Recursive_Solution {
		public List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			preOrder(root, result);
			return result;
		}

		private void preOrder(TreeNode root, List<Integer> list) {
			if (root == null)
				return;
			list.add(root.val);
			preOrder(root.left, list);
			preOrder(root.right, list);
		}
	}
}
