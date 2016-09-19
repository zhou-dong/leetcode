package org.dzhou.leetcode;

import java.util.Stack;

/**
 * 19. Remove Nth Node From End of List
 * 
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * Note: <br>
 * Given n will always be valid. <br>
 * Try to do this in one pass. <br>
 * 
 * @author zhoudong
 *
 */
public class RemoveNthNodeFromEndOfList {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {

		public ListNode removeNthFromEnd(ListNode head, int n) {
			if (head == null)
				return null;

			Stack<ListNode> stack = new Stack<>();
			while (head != null) {
				stack.push(head);
				head = head.next;
			}

			if (stack.size() < n) {
				return null;
			}

			for (int i = 0; i < n - 1; i++) {
				stack.pop();
			}
			return stack.pop();
		}

	}

}
