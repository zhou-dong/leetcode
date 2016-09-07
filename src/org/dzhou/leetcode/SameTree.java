package org.dzhou.leetcode;

import java.util.LinkedList;
import java.util.Queue;

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

	public class Iterator_Solution {
		public boolean isSameTree(TreeNode p, TreeNode q) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(p);
			queue.add(q);
			while (!queue.isEmpty()) {
				TreeNode n1 = queue.poll();
				TreeNode n2 = queue.poll();
				if (n1 == null && n2 == null)
					continue;
				if (n1 == null || n2 == null)
					return false;
				if (n1.val != n2.val)
					return false;
				queue.add(n1.left);
				queue.add(n2.left);
				queue.add(n1.right);
				queue.add(n2.right);
			}
			return true;
		}
	}

	public class Recursive_Solution {
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
