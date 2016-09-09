package org.dzhou.leetcode;

import org.omg.CORBA.Current;

/**
 * 129. Sum Root to Leaf Numbers
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * ----1 <br>
 * ---/-\ <br>
 * --2---3 <br>
 * 
 * The root-to-leaf path 1->2 represents the number 12. <br>
 * The root-to-leaf path 1->3 represents the number 13. <br>
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 * @author zhoudong
 *
 */
public class SumRootToLeafNumbers {

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
		int sum = 0;

		public int sumNumbers(TreeNode root) {
			if (root != null)
				dfs(root, root.val);
			return sum;
		}

		private void dfs(TreeNode root, int current) {
			if (root.left == null && root.right == null) {
				sum += current;
			}
			if (root.left != null) {
				dfs(root.left, current * 10 + root.left.val);
			}
			if (root.right != null) {
				dfs(root.right, current * 10 + root.right.val);
			}
		}
	}

}
