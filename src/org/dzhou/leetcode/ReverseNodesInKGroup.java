package org.dzhou.leetcode;

/**
 * 25. Reverse Nodes in k-Group
 * 
 * @author zhoudong
 *
 */
public class ReverseNodesInKGroup {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	class ReverseResult {
		boolean isReverse;
		ListNode head;
		ListNode tail;

		ReverseResult() {
			this.isReverse = false;
		}

		ReverseResult(ListNode head, ListNode tail) {
			this.isReverse = true;
			this.head = head;
			this.tail = tail;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {

		if (head == null || head.next == null || k < 2)
			return head;

		if (!isEnoughNodes(head, k)) {
			return head;
		}

		ListNode preHead = new ListNode(0);
		ListNode current = preHead;

		ReverseResult reverse = reverseNextK(head, k);
		while (reverse.isReverse == true) {
			current.next = reverse.head;
			current = reverse.tail;
			reverse = reverseNextK(reverse.tail.next, k);
		}

		return preHead.next;
	}

	private ReverseResult reverseNextK(ListNode head, int k) {
		if (!isEnoughNodes(head, k)) {
			return new ReverseResult();
		}
		ListNode preHead = new ListNode(0);
		preHead.next = head;
		for (int i = 1; i < k; i++) {
			ListNode temp = head.next;
			head.next = head.next.next;
			temp.next = preHead.next;
			preHead.next = temp;
		}
		return new ReverseResult(preHead.next, head);
	}

	private boolean isEnoughNodes(ListNode head, int k) {
		int count = 0;
		while (head != null) {
			if (++count == k)
				return true;
			head = head.next;
		}
		return false;
	}

}
