package org.dzhou.other.facebook;

import java.util.Stack;

/**
 * 206. Reverse Linked List
 * 
 * Reverse a singly linked list.
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

	public class Recursive_Solution {

		public ListNode reverseList(ListNode head) {
			if (head == null || head.next == null)
				return head;
			ListNode p = reverseList(head.next);
			head.next.next = head;
			head.next = null;
			return p;
		}

	}

	public class Iterator_Solution {

		public ListNode reverseList(ListNode head) {
			ListNode curr = head;
			ListNode prev = null;
			while (curr != null) {
				ListNode nextTemp = curr.next;
				curr.next = prev;
				prev = curr;
				curr = nextTemp;
			}
			return prev;
		}

	}

}
