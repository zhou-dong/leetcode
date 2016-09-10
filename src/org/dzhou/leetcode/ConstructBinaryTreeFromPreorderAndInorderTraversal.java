package org.dzhou.leetcode;

import java.util.HashMap;
import java.util.Map;

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
			if (preorder == null || inorder == null || preorder.length != inorder.length)
				return null;
			return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1,
					createInOrderIndex(inorder));
		}

		// 索引value在inOrder数组中的index，方便快速查抄。
		private Map<Integer, Integer> createInOrderIndex(int[] inorder) {
			Map<Integer, Integer> inOrderIndex = new HashMap<>();
			for (int i = 0; i < inorder.length; i++)
				inOrderIndex.put(inorder[i], i);
			return inOrderIndex;
		}

		private TreeNode helper(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight,
				Map<Integer, Integer> inOrderIndex) {
			if (preLeft > preRight || inLeft > inRight)
				return null;
			TreeNode root = new TreeNode(preorder[preLeft]);
			// 元素在inOrder中的位置
			int index = inOrderIndex.get(root.val);
			root.left = helper(preorder, inorder, preLeft + 1, index - inLeft + preLeft, inLeft, index - 1,
					inOrderIndex);
			root.right = helper(preorder, inorder, preLeft + index - inLeft + 1, preRight, index + 1, inRight,
					inOrderIndex);
			return root;
		}
	}

	public class Solution1 {
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			if (preorder == null || inorder == null || preorder.length != inorder.length)
				return null;
			init(preorder, inorder);
			return helper(0, preorder.length - 1, 0, inorder.length - 1);
		}

		int[] preorder = null, inorder = null;
		Map<Integer, Integer> inOrderIndex = null;

		private void init(int[] preorder, int[] inorder) {
			this.preorder = preorder;
			this.inorder = inorder;
			this.inOrderIndex = createInOrderIndex(inorder);
		}

		// 索引value在inOrder数组中的index，方便快速查抄。
		private Map<Integer, Integer> createInOrderIndex(int[] inorder) {
			Map<Integer, Integer> inOrderIndex = new HashMap<>();
			for (int i = 0; i < inorder.length; i++)
				inOrderIndex.put(inorder[i], i);
			return inOrderIndex;
		}

		// example:
		// preOrder: A B D E F C G H J L K
		// inOrder : D B F E A G C L J H K
		private TreeNode helper(int preLeft, int preRight, int inLeft, int inRight) {
			if (preLeft > preRight || inLeft > inRight)
				return null;
			TreeNode root = new TreeNode(preorder[preLeft]);
			int index = inOrderIndex.get(root.val);// 元素在inOrder中的位置
			root.left = helper(preLeft + 1, preLeft + index - inLeft, inLeft, index - 1);
			root.right = helper(preLeft + index - inLeft + 1, preRight, index + 1, inRight);
			return root;
		}
	}
}
