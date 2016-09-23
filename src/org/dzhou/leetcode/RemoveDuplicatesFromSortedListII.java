package org.dzhou.leetcode;

/**
 * 82. Remove Duplicates from Sorted List II
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example,
 * 
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * 
 * Given 1->1->1->2->3, return 2->3.
 * 
 * 
 * @author zhoudong
 *
 */
public class RemoveDuplicatesFromSortedListII {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// Given 1->2->3->3->4->4->5, return 1->2->5.
	// Given 1->1->1->2->3, return 2->3.
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode preHead = new ListNode(0);
		preHead.next = head;
		ListNode current = preHead;

		while (current.next != null && current.next.next != null) {
			if (current.next.val == current.next.next.val) {
				int val = current.next.val;
				while (current.next != null && current.next.val == val) {
					current.next = current.next.next;
				}
			} else {
				current = current.next;
			}
		}

		return preHead.next;
	}

}
