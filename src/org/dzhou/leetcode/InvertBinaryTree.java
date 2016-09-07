package org.dzhou.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. Invert Binary Tree
 * 
 * @author zhoudong
 *
 */
public class InvertBinaryTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Recursive_Solution {
		public TreeNode invertTree(TreeNode root) {
			if (root == null)
				return null;
			TreeNode left = invertTree(root.left);
			TreeNode right = invertTree(root.right);
			root.left = right;
			root.right = left;
			return root;
		}
	}

	public class Iterator_Solution {
		public TreeNode invertTree(TreeNode root) {
			if (root == null)
				return null;
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode current = queue.poll();
				TreeNode temp = current.left;
				current.left = current.right;
				current.right = temp;
				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
			}
			return root;
		}
	}

}
