package org.dzhou.other;

import java.util.LinkedList;
import java.util.Queue;

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

	class Dfs_Solution {
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

	class Bfs_Solution {
		public TreeNode invertTree(TreeNode root) {
			if (root == null)
				return null;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode current = queue.poll();
				TreeNode temp = current.left;
				current.left = current.right;
				current.right = temp;
				if (current.left != null)
					queue.add(current.left);
				if (current.right != null)
					queue.add(current.right);
			}
			return root;
		}
	}

}
