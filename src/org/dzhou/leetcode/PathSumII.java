package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 113. Path Sum II
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * @author zhoudong
 *
 */
public class PathSumII {

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

		public List<List<Integer>> pathSum(TreeNode root, int sum) {
			if (root == null)
				return Collections.emptyList();
			List<List<Integer>> result = new ArrayList<>();
			dfs(root, sum, result, new ArrayList<>());
			return result;
		}

		private void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> item) {
			item.add(root.val);
			sum -= root.val;
			if (root.left == null && root.right == null) {
				if (sum == 0) {
					result.add(new ArrayList<>(item));
				}
			}
			if (root.left != null) {
				dfs(root.left, sum, result, item);
				item.remove(item.size() - 1);
			}
			if (root.right != null) {
				dfs(root.right, sum, result, item);
				item.remove(item.size() - 1);
			}
		}

	}

}
