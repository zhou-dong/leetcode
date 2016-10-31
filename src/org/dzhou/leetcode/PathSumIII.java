package org.dzhou.leetcode;

/**
 * 437. Path Sum III
 * 
 * Difficulty: Easy
 * 
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 * 
 * 
 * @author zhoudong
 *
 */
public class PathSumIII {

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

		int count = 0;

		public int pathSum(TreeNode root, int sum) {
			traverse(root, sum);
			return count;
		}

		private void traverse(TreeNode root, int sum) {
			if (root != null) {
				count(root, sum, 0);
				traverse(root.left, sum);
				traverse(root.right, sum);
			}
		}

		private void count(TreeNode root, int sum, int previous) {
			if (root != null) {
				int current = previous + root.val;
				count += (current == sum) ? 1 : 0;
				count(root.left, sum, current);
				count(root.right, sum, current);
			}
		}

	}

}
