package org.dzhou.leetcode;

/**
 * 100. Same Tree
 * 
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 * @author zhoudong
 *
 */
public class SameTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Directly_Compare_Solution {
		public boolean isSameTree(TreeNode p, TreeNode q) {
			if (p == null && q == null)
				return true;
			if (p == null || q == null)
				return false;
			if (p.val != q.val)
				return false;
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}

	public class Copy_And_Compare_Solution {
		public boolean isSameTree(TreeNode p, TreeNode q) {
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			preOrder(p, sb1);
			preOrder(q, sb2);
			return sb1.toString().equals(sb2.toString());
		}

		private void preOrder(TreeNode root, StringBuilder sb) {
			if (root == null) {
				sb.append("x");
				return;
			}
			sb.append(root.val);
			preOrder(root.left, sb);
			preOrder(root.right, sb);
		}
	}

}
