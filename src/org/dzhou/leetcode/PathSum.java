package org.dzhou.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. Path Sum
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * @author zhoudong
 *
 */
public class PathSum {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class DFS_Solution_Elegant {

		public boolean hasPathSum(TreeNode root, int sum) {
			if (root == null)
				return false;
			sum -= root.val;
			if (root.left == null && root.right == null)
				return sum == 0;
			return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
		}

	}

	public class DFS_Solution {

		public boolean hasPathSum(TreeNode root, int sum) {
			if (root == null)
				return false;
			sum -= root.val;
			if (root.left == null && root.right == null) {
				return sum == 0;
			}
			if (hasPathSum(root.left, sum)) {
				return true;
			}
			if (hasPathSum(root.right, sum)) {
				return true;
			}
			return false;
		}

	}

	public class BFS_Solution {

		public boolean hasPathSum(TreeNode root, int sum) {
			if (root == null)
				return false;
			Queue<TreeNode> nodeQueue = new LinkedList<>();
			Queue<Integer> sumQueue = new LinkedList<>();
			nodeQueue.add(root);
			sumQueue.add(sum);
			while (!nodeQueue.isEmpty()) {
				TreeNode node = nodeQueue.poll();
				int current = sumQueue.poll();
				current -= node.val;
				if (node.left == null && node.right == null) {
					if (current == 0)
						return true;
					else
						continue;
				}
				if (node.left != null) {
					nodeQueue.add(node.left);
					sumQueue.add(current);
				}
				if (node.right != null) {
					nodeQueue.add(node.right);
					sumQueue.add(current);
				}
			}
			return false;
		}

	}

}
