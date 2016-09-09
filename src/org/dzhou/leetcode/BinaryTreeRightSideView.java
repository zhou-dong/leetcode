package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 * 
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * @author zhoudong
 *
 */
public class BinaryTreeRightSideView {
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
		public List<Integer> rightSideView(TreeNode root) {
			return root == null ? Collections.emptyList() : bfs(root);
		}

		private List<Integer> bfs(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode current = queue.poll();
					if (i == size - 1) {
						result.add(current.val);
					}
					if (current.left != null) {
						queue.add(current.left);
					}
					if (current.right != null) {
						queue.add(current.right);
					}
				}
			}
			return result;
		}
	}
}
