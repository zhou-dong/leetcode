package org.dzhou.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. Populating Next Right Pointers in Each Node
 * 
 * @author zhoudong
 *
 */
public class PopulatingNextRightPointersInEachNode {

	// Definition for binary tree with next pointer.
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public class Solution {
		public void connect(TreeLinkNode root) {
			if (root != null) {
				bfs(root);
			}
		}

		private void bfs(TreeLinkNode root) {
			Queue<TreeLinkNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeLinkNode node = queue.poll();
					if (i < size - 1) {
						node.next = queue.peek();
					} else {
						node.next = null;
					}
					if (node.left != null) {
						queue.add(node.left);
					}
					if (node.right != null) {
						queue.add(node.right);
					}
				}
			}
		}
	}

}
