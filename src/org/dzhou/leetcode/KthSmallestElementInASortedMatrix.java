package org.dzhou.leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * 
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * @author zhoudong
 *
 */
public class KthSmallestElementInASortedMatrix {

	public class BFS_Heap_Solution {
		class Point implements Comparable<Point> {
			int value;
			int row;
			int col;

			Point(int value, int row, int col) {
				this.value = value;
				this.row = row;
				this.col = col;
			}

			@Override
			public int compareTo(Point o) {
				return this.value - o.value;
			}
		}

		Set<String> visited = null;
		PriorityQueue<Point> heap = null;
		int[][] matrix = null;
		private int[][] rightDown = { { 0, 1 }, { 1, 0 } };

		public int kthSmallest(int[][] matrix, int k) {
			init(matrix);
			int count = 1;
			add(0, 0);
			while (count < k) {
				Point point = heap.poll();
				for (int[] direction : rightDown) {
					int row = point.row + direction[0];
					int col = point.col + direction[1];
					if (isValidLocation(row, col)) {
						add(row, col);
					}
				}
				count++;
			}
			return heap.peek().value;
		}

		private void init(int[][] matrix) {
			this.matrix = matrix;
			this.visited = new HashSet<>();
			this.heap = new PriorityQueue<>();
		}

		private void add(int row, int col) {
			String location = row + "-" + col;
			if (!visited.contains(location)) {
				visited.add(location);
				heap.add(new Point(matrix[row][col], row, col));
			}
		}

		private boolean isValidLocation(int row, int col) {
			return row < matrix.length && col < matrix[row].length;
		}
	}

	public class Heap_Solution {
		public int kthSmallest(int[][] matrix, int k) {
			PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
			for (int[] row : matrix) {
				for (int element : row) {
					queue.add(element);
					if (queue.size() > k) {
						queue.poll();
					}
				}
			}
			return queue.peek();
		}
	}

}
