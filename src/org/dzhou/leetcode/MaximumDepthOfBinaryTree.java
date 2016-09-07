package org.dzhou.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. Maximum Depth of Binary Tree
 * 
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * @author zhoudong
 *
 */
public class MaximumDepthOfBinaryTree {

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
		public int maxDepth(TreeNode root) {
			if (root == null)
				return 0;
			int left = maxDepth(root.left);
			int right = maxDepth(root.right);
			return Math.max(left, right) + 1;
		}
	}

	public class Iterator_Solution {
		public int maxDepth(TreeNode root) {
			if (root == null)
				return 0;
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			int count = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();
				count++;
				for (int i = 0; i < size; i++) {
					TreeNode current = queue.poll();
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
