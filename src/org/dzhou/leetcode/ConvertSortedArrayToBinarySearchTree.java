package org.dzhou.leetcode;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * 
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * @author zhoudong
 *
 */
public class ConvertSortedArrayToBinarySearchTree {
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

		public TreeNode sortedArrayToBST(int[] nums) {
			if (nums == null || nums.length == 0)
				return null;
			return helper(nums, 0, nums.length - 1);
		}

		private TreeNode helper(int[] nums, int start, int end) {
			if (start > end)
				return null;
			int mid = (start + end) / 2;
			TreeNode root = new TreeNode(nums[mid]);
			root.left = helper(nums, start, mid - 1);
			root.right = helper(nums, mid + 1, end);
			return root;
		}

	}

}
