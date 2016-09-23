package org.dzhou.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * @author zhoudong
 *
 *         3种方法：
 *
 *         1. 逐个合并
 *
 *         2. 两两合并
 *
 *         3. 使用priority queue
 */
public class MergeKSortedLists {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Heap_Solution {

		public ListNode mergeKLists(ListNode[] lists) {

			if (lists == null || lists.length == 0)
				return null;
			if (lists.length == 1)
				return lists[0];

			// initial heap
			PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
				@Override
				public int compare(ListNode o1, ListNode o2) {
					return o1.val - o2.val;
				}
			});

			// construction heap with height = list.length;
			for (ListNode head : lists) {
				if (head != null) {
					heap.add(head);
				}
			}

			// create dummy head
			ListNode preHead = new ListNode(0);
			ListNode current = preHead;

			// 1. poll the minimal node from heap
			// 2. connect node result
			// 3. add the next of node into heap
			while (!heap.isEmpty()) {
				ListNode temp = heap.poll();
				current.next = temp;
				current = temp;
				if (temp.next != null) {
					heap.add(temp.next);
					temp.next = null;
				}
			}

			return preHead.next;
		}

	}

	public class Merge_Two_By_Two_Solution {

		public ListNode mergeKLists(ListNode[] lists) {
			if (lists == null || lists.length == 0)
				return null;
			ListNode[] result = lists;
			while (result.length > 1) {
				result = getNewList(result);
			}
			return result[0];
		}

		private ListNode[] getNewList(ListNode[] lists) {
			int len = lists.length / 2 + (lists.length % 2 == 0 ? 0 : 1);
			ListNode[] result = new ListNode[len];
			for (int low = 0, high = lists.length - 1; low <= high; low++, high--) {
				if (low == high) {
					result[low] = lists[low];
				} else {
					result[low] = merge(lists[low], lists[high]);
				}
			}
			return result;
		}

		private ListNode merge(ListNode node1, ListNode node2) {
			ListNode preHead = new ListNode(0);
			ListNode current = preHead;
			while (node1 != null && node2 != null) {
				if (node1.val < node2.val) {
					current.next = node1;
					node1 = node1.next;
				} else {
					current.next = node2;
					node2 = node2.next;
				}
				current = current.next;
			}
			current.next = null;
			if (node1 != null) {
				current.next = node1;
			} else if (node2 != null) {
				current.next = node2;
			}
			return preHead.next;
		}

	}

}
