package org.dzhou.other.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
			if (root == null)
				return Collections.emptyList();
			List<Integer> result = new ArrayList<Integer>();
			helper(result, root, 1);
			return result;
		}

		int maxdepth = 0;

		private void helper(List<Integer> result, TreeNode root, int depth) {
			if (depth > maxdepth) {
				result.add(root.val);
				maxdepth = depth;
			}
			if (root.right != null)
				helper(result, root.right, depth + 1);
			if (root.left != null)
				helper(result, root.left, depth + 1);
		}
	}

}
