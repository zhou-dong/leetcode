package org.dzhou.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * @author zhoudong
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

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
	// 1. mark the last element of the postOrder result as the root element.
	// 2. mark the root element in the inOrder result.
	// 3. root element will divide the inOrder result into left subtree and
	// right subtree.

	// 1. PostOrder traversal的最后一个元素，就是当前树的root。
	// 2. 在inOrder数组中，所有root前面的元素都在（树中）root的左边，root后面的元素都在（树中）root的右边。
	// 3. 循环1和2，就可以构建出整棵树。
	public class Solution {

		public TreeNode buildTree(int[] inorder, int[] postorder) {
			if (postorder == null || inorder == null || postorder.length != inorder.length)
				return null;
			init(inorder, postorder);
			return helper(0, inorder.length - 1, 0, postorder.length - 1);
		}

		int[] inorder = null, postorder = null;
		Map<Integer, Integer> inOrderIndex = null;

		private void init(int[] inorder, int[] postorder) {
			this.inorder = inorder;
			this.postorder = postorder;
			this.inOrderIndex = createInOrderIndex(inorder);
		}

		// 索引value在inOrder数组中的index，方便快速查抄。
		private Map<Integer, Integer> createInOrderIndex(int[] inorder) {
			Map<Integer, Integer> inOrderIndex = new HashMap<>();
			for (int i = 0; i < inorder.length; i++)
				inOrderIndex.put(inorder[i], i);
			return inOrderIndex;
		}

		private TreeNode helper(int inLeft, int inRight, int postLeft, int postRight) {
			if (postLeft > postRight || inLeft > inRight)
				return null;
			TreeNode root = new TreeNode(postorder[postRight]);
			int index = inOrderIndex.get(root.val);// 元素在inOrder中的位置
			root.left = helper(inLeft, index - 1, postLeft, postLeft + index - inLeft - 1);
			root.right = helper(index + 1, inRight, postRight - (inRight - index), postRight - 1);
			return root;
		}

	}

}
