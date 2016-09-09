package org.dzhou.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 * 
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * @author zhoudong
 *
 */
public class SerializeAndDeserializeBinaryTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			return root == null ? "" : bfs(root);
		}

		private String bfs(TreeNode root) {
			StringBuilder result = new StringBuilder();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode current = queue.poll();
				if (current == null) {
					result.append("null,");
				} else {
					result.append(current.val).append(",");
					queue.add(current.left);
					queue.add(current.right);
				}
			}
			return result.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			return (data == null || data.length() == 0) ? null : deserialize(data.split(","));
		}

		private TreeNode deserialize(String[] vals) {
			TreeNode[] nodes = new TreeNode[vals.length];
			int[] nulls = new int[vals.length]; // 节点i之前null节点的个数
			for (int i = 0; i < vals.length; i++) {
				nulls[i] = (i == 0) ? 0 : nulls[i - 1];
				if ("null".equals(vals[i])) {
					nulls[i]++;
				} else {
					nodes[i] = new TreeNode(Integer.parseInt(vals[i]));
				}
			}

			for (int i = 0; i < nodes.length; i++) {
				TreeNode current = nodes[i];
				if (current != null) {
					int leftIndex = leftIndex(i, nulls[i]);
					current.left = nodes[leftIndex];
					current.right = nodes[leftIndex + 1];
				}
			}
			return nodes[0];
		}

		private int leftIndex(int index, int preNulls) {
			return leftIndex(index - preNulls);
		}

		private int leftIndex(int index) {
			return 2 * index + 1;
		}
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));

}
