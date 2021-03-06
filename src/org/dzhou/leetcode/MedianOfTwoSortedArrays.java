package org.dzhou.leetcode;

import java.util.Arrays;

/**
 * 4. Median of Two Sorted Arrays
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * Example 1: <br>
 * nums1 = [1, 3] <br>
 * nums2 = [2] <br>
 * The median is 2.0
 * 
 * Example 2: <br>
 * nums1 = [1, 2] <br>
 * nums2 = [3, 4] <br>
 * The median is (2 + 3)/2 = 2.5
 * 
 * @author zhoudong
 *
 */
public class MedianOfTwoSortedArrays {

	// O(Log(Min(m,n)))
	public class Binary_Search_Solution {

		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			int len = nums1.length + nums2.length;
			if (len % 2 == 0)
				return (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
			else
				return findKth(nums1, 0, nums2, 0, len / 2 + 1);
		}

		// find kth number of two sorted array
		public int findKth(int[] A, int A_start, int[] B, int B_start, int k) {
			if (A_start >= A.length) {
				return B[B_start + k - 1];
			}
			if (B_start >= B.length) {
				return A[A_start + k - 1];
			}

			if (k == 1) {
				return Math.min(A[A_start], B[B_start]);
			}

			int A_key = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
			int B_key = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;

			if (A_key < B_key) {
				return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
			} else {
				return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
			}
		}
	}

	// O(N(Log(M+N)))
	public class Brute_Force_Solution {

		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			int[] nums3 = new int[nums1.length + nums2.length];
			for (int i = 0; i < nums1.length; i++)
				nums3[i] = nums1[i];
			for (int i = 0; i < nums2.length; i++)
				nums3[i + nums1.length] = nums2[i];
			Arrays.sort(nums3);
			return (nums3.length % 2 == 0) ? (nums3[nums3.length / 2 - 1] + nums3[nums3.length / 2]) / 2.0
					: nums3[nums3.length / 2];
		}

	}

	// O(M+N)
	public class Merge_Solution {

		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			int[] nums3 = merge(nums1, nums2);
			return (nums3.length % 2 == 0) ? (nums3[nums3.length / 2 - 1] + nums3[nums3.length / 2]) / 2.0
					: nums3[nums3.length / 2];
		}

		private int[] merge(int[] nums1, int[] nums2) {
			int[] result = new int[nums1.length + nums2.length];
			for (int index = 0, index1 = 0, index2 = 0; index < result.length; index++) {
				if (index1 == nums1.length) {
					result[index] = nums2[index2++];
				} else if (index2 == nums2.length) {
					result[index] = nums1[index1++];
				} else {
					if (nums1[index1] < nums2[index2])
						result[index] = nums1[index1++];
					else
						result[index] = nums2[index2++];
				}
			}
			return result;
		}

	}

}
