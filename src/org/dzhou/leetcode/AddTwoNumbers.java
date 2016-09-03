package org.dzhou.leetcode;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author zhoudong
 *
 */
public class AddTwoNumbers {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// iterator
	public class Solution {

		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			if (l1 == null)
				return l2;
			if (l2 == null)
				return l1;

			ListNode head = new ListNode(0);
			ListNode current = head;

			int carry = 0;
			while (l1 != null || l2 != null) {
				int value = carry;
				if (l1 != null) {
					value += l1.val;
					l1 = l1.next;
				}
				if (l2 != null) {
					value += l2.val;
					l2 = l2.next;
				}
				carry = value / 10;
				current.next = new ListNode(value % 10);
				current = current.next;
			}

			if (carry != 0)
				current.next = new ListNode(carry);

			return head.next;
		}

	}

	// recursive
	public class Solution1 {

		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			if (l1 == null)
				return l2;
			if (l2 == null)
				return l1;
			ListNode head = new ListNode(0);
			recursive(head, l1, l2, 0);
			return head.next;
		}

		private void recursive(ListNode head, ListNode l1, ListNode l2, int carry) {
			if (l1 == null && l2 == null) {
				if (carry == 1)
					head.next = new ListNode(1);
				return;
			}

			int value = carry;
			value += (l1 == null) ? 0 : l1.val;
			value += (l2 == null) ? 0 : l2.val;

			head.next = new ListNode(value % 10);

			recursive(head.next, l1 == null ? null : l1.next, l2 == null ? null : l2.next, value / 10);
		}

	}

}
