package org.dzhou.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. Linked List Cycle II
 * 
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Note: Do not modify the linked list.
 * 
 * Follow up:
 * 
 * Can you solve it without using extra space?
 * 
 * @author zhoudong
 *
 */
public class LinkedListCycleII {

	// Definition for singly-linked list.
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public class Solution {
		public ListNode detectCycle(ListNode head) {
			ListNode slow = head, fast = head;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
				if (slow == fast) {
					break;
				}
			}
			// no intersection
			if (fast == null || fast.next == null) {
				return null;
			}
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
	}

	public class Solution1 {
		public ListNode detectCycle(ListNode head) {
			Set<ListNode> set = new HashSet<>();
			while (head != null) {
				if (set.contains(head))
					return head;
				set.add(head);
				head = head.next;
			}
			return null;
		}
	}

}
