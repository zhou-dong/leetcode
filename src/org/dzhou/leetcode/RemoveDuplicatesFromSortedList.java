package org.dzhou.leetcode;

/**
 * 83. Remove Duplicates from Sorted List
 * 
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example,
 * 
 * Given 1->1->2, return 1->2.
 * 
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * 
 * @author zhoudong
 *
 */
public class RemoveDuplicatesFromSortedList {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		while (current != null && current.next != null) {
			if (current.val == current.next.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}

}
