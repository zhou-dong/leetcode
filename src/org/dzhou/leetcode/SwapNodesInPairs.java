package org.dzhou.leetcode;

/**
 * 24. Swap Nodes in Pairs
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * @author zhoudong
 *
 */
public class SwapNodesInPairs {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// Given 1->2->3->4, you should return the list as 2->1->4->3.
	public class Solution {
		public ListNode swapPairs(ListNode head) {

			if (head == null || head.next == null)
				return head;
		}
	}
}
