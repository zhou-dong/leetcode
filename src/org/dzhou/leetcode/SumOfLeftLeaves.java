package org.dzhou.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. Sum of Left Leaves
 * 
 * @author zhoudong
 *
 */
public class SumOfLeftLeaves {

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
		int sum = 0;

		public int sumOfLeftLeaves(TreeNode root) {
			dfs(root, false);
			return sum;
		}

		private void dfs(TreeNode node, boolean isLeft) {
			if (node == null)
				return;
			if (node.left == null && node.right == null && isLeft)
				sum += node.val;
			dfs(node.left, true);
			dfs(node.right, false);
		}
	}

	public class BFS_Solution {
		public int sumOfLeftLeaves(TreeNode root) {
			if (root == null)
				return 0;
			int sum = 0;
			Queue<TreeNode> nodes = new LinkedList<>();
			Queue<Boolean> isLefts = new LinkedList<>();
			nodes.add(root);
			isLefts.add(false);
			while (!nodes.isEmpty()) {
				TreeNode node = nodes.poll();
				boolean isLeft = isLefts.poll();
				if (node.left == null && node.right == null && isLeft)
					sum += node.val;
				if (node.left != null) {
					nodes.add(node.left);
					isLefts.add(true);
				}
				if (node.right != null) {
					nodes.add(node.right);
					isLefts.add(false);
				}
			}
			return sum;
		}
	}

	public class BFS_Modify_Node_Solution {
		private class Node {
			TreeNode treeNode;
			boolean isLeft;

			Node(TreeNode treeNode, boolean isLeft) {
				this.treeNode = treeNode;
				this.isLeft = isLeft;
			}
		}

		public int sumOfLeftLeaves(TreeNode root) {
			if (root == null)
				return 0;
			int sum = 0;
			Queue<Node> nodes = new LinkedList<>();
			nodes.add(new Node(root, false));
			while (!nodes.isEmpty()) {
				Node node = nodes.poll();
				TreeNode treeNode = node.treeNode;
				if (treeNode.left == null && treeNode.right == null && node.isLeft)
					sum += treeNode.val;
				if (treeNode.left != null)
					nodes.add(new Node(treeNode.left, true));
				if (treeNode.right != null) {
					nodes.add(new Node(treeNode.right, false));
				}
			}
			return sum;
		}
	}

}
