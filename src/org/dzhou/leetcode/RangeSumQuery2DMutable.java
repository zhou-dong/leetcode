package org.dzhou.leetcode;

/**
 * 308. Range Sum Query 2D - Mutable
 * 
 * Example: <br>
 * Given matrix = [ <br>
 * --[3, 0, 1, 4, 2], <br>
 * --[5, 6, 3, 2, 1], <br>
 * --[1, 2, 0, 1, 5], <br>
 * --[4, 1, 0, 1, 7], <br>
 * --[1, 0, 3, 0, 5] <br>
 * ] <br>
 * 
 * sumRegion(2, 1, 4, 3) -> 8 <br>
 * update(3, 2, 2) <br>
 * sumRegion(2, 1, 4, 3) -> 10 <br>
 * 
 * Note:
 * 
 * The matrix is only modifiable by the update function. <br>
 * You may assume the number of calls to update and sumRegion function is
 * distributed evenly. <br>
 * You may assume that row1 ≤ row2 and col1 ≤ col2. <br>
 * 
 * @author zhoudong
 *
 */
public class RangeSumQuery2DMutable {

	public class NumMatrix {

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

		class SegmentTree {
			int size;
			SegmentTreeNode root;

			public SegmentTree(int[] nums) {
				if (nums == null || nums.length == 0)
					return;
				root = buildTree(nums, 0, nums.length - 1);
				size = nums.length;
			}

			private SegmentTreeNode buildTree(int[] nums, int low, int high) {
				if (low == high)
					return new SegmentTreeNode(low, high, nums[low]);
				SegmentTreeNode root = new SegmentTreeNode(low, high);
				int mid = (low + high) / 2;
				root.left = buildTree(nums, low, mid);
				root.right = buildTree(nums, mid + 1, high);
				root.value = root.left.value + root.right.value;
				return root;
			}

			public void update(int i, int value) {
				if (i < 0 || i >= size)
					return;
				update(root, i, value);
			}

			private int update(SegmentTreeNode root, int i, int value) {
				if (root.low == i && root.high == i) {
					int old = root.value;
					root.value = value;
					return old;
				}
				int mid = (root.low + root.high) / 2;
				int old = 0;
				if (i <= mid)
					old = update(root.left, i, value);
				else
					old = update(root.right, i, value);
				root.value = root.value - old + value;
				return old;
			}

			public int sumRange(int i, int j) {
				if (i < 0 || j >= size || i > j)
					return -1;
				return sumRange(root, i, j);
			}

			private int sumRange(SegmentTreeNode root, int i, int j) {
				if (i == root.low && j == root.high) {
					return root.value;
				}
				int mid = (root.low + root.high) / 2;
				if (i <= mid && j <= mid) {
					return sumRange(root.left, i, j);
				} else if (i > mid && j > mid) {
					return sumRange(root.right, i, j);
				} else {
					return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
				}
			}
		}

		SegmentTree[] trees = null;

		public NumMatrix(int[][] matrix) {
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
				return;
			trees = new SegmentTree[matrix.length];
			for (int i = 0; i < trees.length; i++) {
				trees[i] = new SegmentTree(matrix[i]);
			}
		}

		public void update(int row, int col, int val) {
			if (isValid(row, col)) {
				trees[row].update(col, val);
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			if (!isValid(row1, col1, row2, col2))
				return -1;
			int sum = 0;
			for (int row = row1; row <= row2; row++)
				sum += trees[row].sumRange(col1, col2);
			return sum;
		}

		private boolean isValid(int row1, int col1, int row2, int col2) {
			return isValid(row1, col1) && isValid(row2, col2) && row1 <= row2 && col1 <= col2;
		}

		private boolean isValid(int row, int col) {
			if (trees == null || trees.length == 0)
				return false;
			if (row < 0 || row >= trees.length || col < 0 || col >= trees[row].size)
				return false;
			return true;
		}
	}

	// Your NumMatrix object will be instantiated and called as such:
	// NumMatrix numMatrix = new NumMatrix(matrix);
	// numMatrix.sumRegion(0, 1, 2, 3);
	// numMatrix.update(1, 1, 10);
	// numMatrix.sumRegion(1, 2, 3, 4);
}
