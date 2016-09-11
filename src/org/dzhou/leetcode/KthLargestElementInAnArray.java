package org.dzhou.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * @author zhoudong
 *
 */
public class KthLargestElementInAnArray {

	public class Solution_N_LogK {
		public int findKthLargest(int[] nums, int k) {
			PriorityQueue<Integer> heap = new PriorityQueue<>();
			for (int num : nums) {
				heap.add(num);
				if (heap.size() > k) {
					heap.poll();
				}
			}
			return heap.peek();
		}

	}

	public class Solution_N_LogN {
		public int findKthLargest(int[] nums, int k) {
			PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
			for (int num : nums)
				heap.add(num);
			for (int i = 0; i < k - 1; i++)
				heap.poll();
			return heap.peek();
		}
	}
}
