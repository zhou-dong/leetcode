package org.dzhou.leetcode;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * @author zhoudong
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// steps:
	// 1. mark the first element of the preOrder result as the root element.
	// 2. mark the root element in the inOrder result.
	// 3. root element will divide the inOrder result into left subtree and
	// right subtree.

	// 1. PreOrder 的第一个元素，就是当前树的root。
	// 2. 在inOrder数组中，所有root前面的元素都在（树中）root的左边，root后面的元素都在（树中）root的右边。
	// 3. 循环1和2，就可以构建出整棵树。
	public class Solution {

		public TreeNode buildTree(int[] preorder, int[] inorder) {

			return null;
		}

	}

}
