package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 145. Binary Tree Postorder Traversal
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author zhoudong
 *
 */
public class BinaryTreePostorderTraversal {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Two_Stack_Solution {
		public List<Integer> postorderTraversal(TreeNode root) {
			if (root == null)
				return Collections.emptyList();
			Stack<TreeNode> stack = treeToStack(root);
			return stackToList(stack);
		}

		// post traversal: left, right, parent
		private Stack<TreeNode> treeToStack(TreeNode root) {
			Stack<TreeNode> stack1 = new Stack<>();
			Stack<TreeNode> stack2 = new Stack<>();
			stack1.add(root);
			while (!stack1.isEmpty()) {
				TreeNode node = stack1.pop();
				if (node.left != null) {
					stack1.push(node.left);
				}
				if (node.right != null) {
					stack1.push(node.right);
				}
				stack2.push(node);
			}
			return stack2;
		}

		private List<Integer> stackToList(Stack<TreeNode> stack) {
			List<Integer> result = new ArrayList<>();
			while (!stack.isEmpty())
				result.add(stack.pop().val);
			return result;
		}
	}

	// post traversal: left, right, parent
	public class Iterative_Solution {
		public List<Integer> postorderTraversal(TreeNode root) {
			if (root == null)
				return Collections.emptyList();
			List<Integer> result = new ArrayList<>();
			Stack<TreeNode> stack = new Stack<>();
			stack.push(root);
			while (!stack.isEmpty()) {
				TreeNode top = stack.peek();
				if (top.left == null && top.right == null) {
					result.add(stack.pop().val);
				}
				if (top.left != null) {
					stack.push(top.left);
					top.left = null;
					continue;
				}
				if (top.right != null) {
					stack.push(top.right);
					top.right = null;
					continue;
				}
			}
			return result;
		}
	}

	public class Recursive_Solution {
		public List<Integer> postorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			postOrder(root, result);
			return result;
		}

		private void postOrder(TreeNode root, List<Integer> result) {
			if (root == null)
				return;
			postOrder(root.left, result);
			postOrder(root.right, result);
			result.add(root.val);
		}
	}

}
