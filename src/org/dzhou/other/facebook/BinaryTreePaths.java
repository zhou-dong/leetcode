package org.dzhou.other.facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 257. Binary Tree Paths
 * 
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 
 * @author zhoudong
 *
 */
public class BinaryTreePaths {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {

		public List<String> binaryTreePaths(TreeNode root) {
			if (root == null) {
				return Collections.emptyList();
			}
			List<String> result = new ArrayList<>();
			preOrder(root, result, "");
			return result;
		}

		private void preOrder(TreeNode node, List<String> result, String path) {
			if (node.left == null && node.right == null) {
				result.add(path + node.val);
				return;
			}
			if (node.left != null) {
				preOrder(node.left, result, path + node.val + "->");
			}
			if (node.right != null) {
				preOrder(node.right, result, path + node.val + "->");
			}
		}

	}

}
