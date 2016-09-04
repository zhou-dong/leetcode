package org.dzhou.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. Linked List Cycle
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: <br>
 * Can you solve it without using extra space?
 * 
 * @author zhoudong
 *
 */
public class LinkedListCycle {

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
		public boolean hasCycle(ListNode head) {
			ListNode slow = head, fast = head;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
				if (slow == fast) {
					return true;
				}
			}
			return false;
		}
	}

	public class Solution1 {
		public boolean hasCycle(ListNode head) {
			Set<ListNode> set = new HashSet<>();
			while (head != null) {
				if (set.contains(head))
					return true;
				set.add(head);
				head = head.next;
			}
			return false;
		}
	}

}
