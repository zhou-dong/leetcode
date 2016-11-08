package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 305. Number of Islands II
 * 
 * Difficulty: Hard
 * 
 * A 2d grid map of m rows and n columns is initially filled with water. We may
 * perform an addLand operation which turns the water at position (row, col)
 * into a land. Given a list of positions to operate, count the number of
 * islands after each addLand operation. An island is surrounded by water and is
 * formed by connecting adjacent lands horizontally or vertically. You may
 * assume all four edges of the grid are all surrounded by water.
 * 
 * Example:
 * 
 * Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]. <br>
 * 
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water
 * and 1 represents land).
 * 
 * 0 0 0 <br>
 * 0 0 0 <br>
 * 0 0 0 <br>
 * 
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * 
 * 1 0 0 <br>
 * 0 0 0 Number of islands = 1 <br>
 * 0 0 0 <br>
 * 
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 * 
 * 1 1 0 <br>
 * 0 0 0 Number of islands = 1 <br>
 * 0 0 0 <br>
 * 
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 * 
 * 1 1 0 <br>
 * 0 0 1 Number of islands = 2 <br>
 * 0 0 0 <br>
 * 
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 * 
 * 1 1 0 <br>
 * 0 0 1 Number of islands = 3 <br>
 * 0 1 0 <br>
 * 
 * We return the result as an array: [1, 1, 2, 3]
 * 
 * Challenge:
 * 
 * Can you do it in time complexity O(k log mn), where k is the length of the
 * positions?
 * 
 * @author zhoudong
 *
 */
public class NumberOfIslandsII {

	class TreeNode {
		String index;
		TreeNode parent;
		int rank;

		TreeNode(String index) {
			this.index = index;
			this.parent = this;
			this.rank = 0;
		}
	}

	class UnionFind {
		Map<String, TreeNode> map;
		int size;

		UnionFind() {
			this.map = new HashMap<>();
			this.size = 0;
		}

		void addNode(String index) {
			map.put(index, new TreeNode(index));
			size++;
		}

		// true if index1, index2 are in different sets before union else false.
		boolean union(String index1, String index2) {
			if (!map.containsKey(index1) || !map.containsKey(index2)) {
				return false;
			}

			TreeNode node1 = map.get(index1);
			TreeNode node2 = map.get(index2);

			TreeNode parent1 = findSet(node1);
			TreeNode parent2 = findSet(node2);
			if (parent1 == parent2) {
				return false;
			}

			if (parent1.rank >= parent2.rank) {
				parent1.rank += (parent1.rank == parent2.rank) ? 1 : 0;
				parent2.parent = parent1;
			} else {
				parent1.parent = parent2;
			}

			size--;
			return true;
		}

		// Find the parent recursively and does path compression as well.
		TreeNode findSet(TreeNode node) {
			if (node.parent == node)
				return node;
			node.parent = findSet(node.parent);
			return node.parent;
		}
	}

	private String oneDimensionIndex(int x, int y) {
		return x + "-" + y;
	}

	private String neighborIndex(int x, int y, int[] direction) {
		return oneDimensionIndex(x + direction[0], y + direction[1]);
	}

	private int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		UnionFind unionFind = new UnionFind();
		List<Integer> result = new ArrayList<>();
		for (int[] position : positions) {
			String index = oneDimensionIndex(position[0], position[1]);
			unionFind.addNode(index);
			for (int[] direction : directions) {
				String neighbor = neighborIndex(position[0], position[1], direction);
				unionFind.union(index, neighbor);
			}
			result.add(unionFind.size);
		}
		return result;
	}

}
