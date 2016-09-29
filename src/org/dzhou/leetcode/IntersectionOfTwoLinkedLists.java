package org.dzhou.leetcode;

/**
 * 160. Intersection of Two Linked Lists
 * 
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * For example, the following two linked lists:
 * 
 * begin to intersect at node c1.<br>
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null.<br>
 * The linked lists must retain their original structure after the function
 * returns.<br>
 * You may assume there are no cycles anywhere in the entire linked structure.
 * <br>
 * Your code should preferably run in O(n) time and use only O(1) memory.<br>
 * 
 * @author zhoudong
 *
 */
public class IntersectionOfTwoLinkedLists {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		int aLength = 0, bLength = 0;
		ListNode a = headA, b = headB;

		while (a.next != null) {
			aLength++;
			a = a.next;
		}
		while (b.next != null) {
			bLength++;
			b = b.next;
		}

		if (a != b) {
			return null;
		}

		if (aLength != bLength) {
			boolean aIsLonger = aLength > bLength ? true : false;
			int steps = Math.abs(aLength - bLength);
			if (aIsLonger) {
				for (int i = 0; i < steps; i++) {
					headA = headA.next;
				}
			} else {
				for (int i = 0; i < steps; i++) {
					headB = headB.next;
				}
			}
		}

		while (headA != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

}
