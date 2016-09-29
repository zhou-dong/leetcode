package org.dzhou.leetcode;

/**
 * 203. Remove Linked List Elements
 * 
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example<br>
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6<br>
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * 
 * @author zhoudong
 *
 */
public class RemoveLinkedListElements {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeElements(ListNode head, int val) {
		ListNode preHead = new ListNode(0);
		preHead.next = head;
		ListNode current = preHead;
		while (current != null && current.next != null) {
			if (current.next.val == val)
				current.next = current.next.next;
			else
				current = current.next;
		}
		return preHead.next;
	}

}
