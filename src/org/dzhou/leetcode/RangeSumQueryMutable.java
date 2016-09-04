package org.dzhou.leetcode;

/**
 * 307. Range Sum Query - Mutable
 * 
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * The update(i, val) function modifies nums by updating the element at index i
 * to val.
 * 
 * Example: <br>
 * Given nums = [1, 3, 5] <br>
 * 
 * sumRange(0, 2) -> 9 <br>
 * update(1, 2) <br>
 * sumRange(0, 2) -> 8 <br>
 * 
 * Note:
 * 
 * The array is only modifiable by the update function. <br>
 * You may assume the number of calls to update and sumRange function is
 * distributed evenly.
 * 
 * @author zhoudong
 *
 */
public class RangeSumQueryMutable {

	public class NumArray {

		class SegmentTreeNode {
			int value;
			int low;
			int high;

			SegmentTreeNode left;
			SegmentTreeNode right;

			SegmentTreeNode(int low, int high) {
				this.low = low;
				this.high = high;
			}

			SegmentTreeNode(int low, int high, int value) {
				this(low, high);
				this.value = value;
			}
		}

		SegmentTreeNode root = null;
		int size = 0;

		public NumArray(int[] nums) {
			if (nums == null || nums.length == 0)
				return;
			root = buildSegmentTree(nums, 0, nums.length - 1);
			size = nums.length;
		}

		private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end) {
			if (start == end)
				return new SegmentTreeNode(start, end, nums[start]);

			SegmentTreeNode root = new SegmentTreeNode(start, end);

			int mid = (start + end) / 2;
			root.left = buildSegmentTree(nums, start, mid);
			root.right = buildSegmentTree(nums, mid + 1, end);
			root.value = root.left.value + root.right.value;

			return root;
		}

		void update(int i, int val) {
			if (i < 0 || i >= size)
				return;
			update(root, i, val);
		}

		private int update(SegmentTreeNode root, int i, int val) {
			if (i == root.low && i == root.high) {
				int old = root.value;
				root.value = val;
				return old;
			}
			int mid = (root.low + root.high) / 2;
			int old = 0;
			if (i <= mid) {
				old = update(root.left, i, val);
			} else {
				old = update(root.right, i, val);
			}
			root.value = root.value - old + val;
			return old;
		}

		public int sumRange(int i, int j) {
			if (i < 0 || j >= size || i > j)
				return -1;
			return sumRange(root, i, j);
		}

		private int sumRange(SegmentTreeNode root, int i, int j) {
			if (root.low == i && root.high == j)
				return root.value;
			int mid = (root.low + root.high) / 2;
			if (i <= mid && j <= mid)
				return sumRange(root.left, i, j);
			else if (i > mid && j > mid)
				return sumRange(root.right, i, j);
			else {
				return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
			}
		}
	}

	// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.update(1, 10);
	// numArray.sumRange(1, 2);
}
