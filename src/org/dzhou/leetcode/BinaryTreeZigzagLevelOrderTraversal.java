package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * @author zhoudong
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {

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
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			return root == null ? Collections.emptyList() : bfs(root);
		}

		private List<List<Integer>> bfs(TreeNode root) {
			List<List<Integer>> result = new ArrayList<>();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			boolean reverse = false;
			while (!queue.isEmpty()) {
				int size = queue.size();
				List<Integer> item = new ArrayList<>();
				for (int i = 0; i < size; i++) {
					TreeNode current = queue.poll();
					item.add(current.val);
					if (current.left != null) {
						queue.add(current.left);
					}
					if (current.right != null) {
						queue.add(current.right);
					}
				}
				if (reverse) {
					Collections.reverse(item);
				}
				reverse = !reverse;
				result.add(item);
			}
			return result;
		}
	}

}
