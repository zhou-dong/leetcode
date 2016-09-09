package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 * 
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1...n.
 * 
 * @author zhoudong
 *
 */
public class UniqueBinarySearchTreesII {

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

		public List<TreeNode> generateTrees(int n) {
			return (n < 1) ? Collections.emptyList() : generateTrees(1, n);
		}

		private List<TreeNode> generateTrees(int left, int right) {
			List<TreeNode> result = new ArrayList<TreeNode>();
			if (left > right) {
				result.add(null);
				return result;
			}
			for (int i = left; i <= right; i++) {
				// 以i作为根节点，左子树由[1,i-1]构成，右子树由[i+1, n]构成
				List<TreeNode> lefts = generateTrees(left, i - 1);
				// 
				List<TreeNode> rights = generateTrees(i + 1, right);
				for (int j = 0; j < lefts.size(); j++) {
					for (int k = 0; k < rights.size(); k++) {
						TreeNode root = new TreeNode(i);
						root.left = lefts.get(j);
						root.right = rights.get(k);
						result.add(root);// 存储所有可能行
					}
				}
			}
			return result;
		}

	}

}
