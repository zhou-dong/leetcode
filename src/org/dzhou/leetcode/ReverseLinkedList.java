package org.dzhou.leetcode;

import java.util.Stack;

/**
 * 206. Reverse Linked List
 * 
 * Reverse a singly linked list.
 * 
 * Hint: A linked list can be reversed either iteratively or recursively. Could
 * you implement both?
 * 
 * @author zhoudong
 *
 */
public class ReverseLinkedList {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Iterative_Solution {
		public ListNode reverseList(ListNode head) {
			if (head == null)
				return null;
			ListNode dummy = new ListNode(-1);
			dummy.next = head;
			while (head.next != null) {
				ListNode temp = dummy.next;
				dummy.next = head.next;
				head.next = head.next.next;
				dummy.next.next = temp;
			}
			return dummy.next;
		}
	}

	public class Recursive_Solution {
		public ListNode reverseList(ListNode head) {
			return head == null ? null : recursive(head);
		}

		private ListNode recursive(ListNode head) {
			if (head.next == null)
				return head;
			ListNode newHead = recursive(head.next);
			head.next.next = head;
			head.next = null;
			return newHead;
		}
	}

	public class Stack_Solution {
		public ListNode reverseList(ListNode head) {
			if (head == null)
				return null;
			Stack<ListNode> stack = new Stack<>();
			while (head != null) {
				stack.add(head);
				head = head.next;
			}
			head = stack.pop();
			ListNode current = head;
			while (!stack.isEmpty()) {
				current.next = stack.pop();
				current = current.next;
			}
			current.next = null;
			return head;
		}
	}

}
