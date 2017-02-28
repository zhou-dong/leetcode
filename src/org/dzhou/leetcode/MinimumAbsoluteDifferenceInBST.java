package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Minimum Absolute Difference in BST
 * 
 * @author zhoudong
 *
 */
public class MinimumAbsoluteDifferenceInBST {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Inorder_Solution {
		public int getMinimumDifference(TreeNode root) {
			List<Integer> list = new ArrayList<>();
			inorder(root, list);
			return getMinimumDifference(list);
		}

		private void inorder(TreeNode root, List<Integer> list) {
			if (root != null) {
				inorder(root.left, list);
				list.add(root.val);
				inorder(root.right, list);
			}
		}

		private int getMinimumDifference(List<Integer> list) {
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < list.size(); i++) {
				min = Math.min(min, getMinDiff(list.get(i), getPrev(list, i), getNext(list, i)));
			}
			return min;
		}

		private int getMinDiff(int val, int prev, int next) {
			return Math.min(Math.abs(val - prev), Math.abs(next - val));
		}

		private int getPrev(List<Integer> list, int index) {
			return index == 0 ? Integer.MAX_VALUE : list.get(index - 1);
		}

		private int getNext(List<Integer> list, int index) {
			return index == list.size() - 1 ? Integer.MAX_VALUE : list.get(index + 1);
		}
	}

	public class Definition_Solution {
		public int getMinimumDifference(TreeNode root) {
			int[] min = { Integer.MAX_VALUE };
			traverse(root, min);
			return min[0];
		}

		private void traverse(TreeNode root, int[] min) {
			if (root == null)
				return;
			min[0] = getMinimumDifference(root, min[0]);
			traverse(root.left, min);
			traverse(root.right, min);
		}

		private int getMinimumDifference(TreeNode root, int min) {
			int temp = getMinimumDifference(root.val, rightMost(root.left), leftMost(root.right));
			return Math.min(temp, min);
		}

		private int getMinimumDifference(int target, int left, int right) {
			return Math.min(Math.abs(target - left), Math.abs(right - target));
		}

		private int leftMost(TreeNode root) {
			return root == null ? Integer.MAX_VALUE : root.left == null ? root.val : leftMost(root.left);
		}

		private int rightMost(TreeNode root) {
			return root == null ? Integer.MAX_VALUE : root.right == null ? root.val : rightMost(root.right);
		}
	}

}
