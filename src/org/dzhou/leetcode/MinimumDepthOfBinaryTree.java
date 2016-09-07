package org.dzhou.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. Minimum Depth of Binary Tree
 * 
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * @author zhoudong
 *
 */
public class MinimumDepthOfBinaryTree {

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
		public int minDepth(TreeNode root) {
			return (root == null) ? 0 : helper(root);
		}

		private int helper(TreeNode root) {
			if (root.left == null && root.right == null)
				return 1;
			int left = (root.left == null) ? Integer.MAX_VALUE : minDepth(root.left);
			int right = (root.right == null) ? Integer.MAX_VALUE : minDepth(root.right);
			return Math.min(left, right) + 1;
		}
	}

	public class DFS_Solution1 {
		public int minDepth(TreeNode root) {
			if (root == null)
				return 0;
			if (root.left == null && root.right == null)
				return 1;
			int left = Integer.MAX_VALUE;
			if (root.left != null)
				left = minDepth(root.left);
			int right = Integer.MAX_VALUE;
			if (root.right != null)
				right = minDepth(root.right);
			return Math.min(left, right) + 1;
		}
	}

	public class BFS_Solution {
		public int minDepth(TreeNode root) {
			if (root == null)
				return 0;
			int count = 0;
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				count++;
				for (int i = 0; i < size; i++) {
					TreeNode current = queue.poll();
					if (current.left == null && current.right == null) {
						return count;
					}
					if (current.left != null) {
						queue.add(current.left);
					}
					if (current.right != null) {
						queue.add(current.right);
					}
				}
			}
			return count;
		}
	}

}
