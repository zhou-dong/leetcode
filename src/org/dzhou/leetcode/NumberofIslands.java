package org.dzhou.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. Number of Islands
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 11110 <br>
 * 11010 <br>
 * 11000 <br>
 * 00000 <br>
 * 
 * Answer: 1
 * 
 * Example 2:
 * 
 * 11000 <br>
 * 11000 <br>
 * 00100 <br>
 * 00011 <br>
 * 
 * Answer: 3
 * 
 * @author zhoudong
 *
 */
public class NumberofIslands {

	// DFS
	public class Solution1 {

		public int numIslands(char[][] grid) {
			if (grid == null || grid.length == 0 || grid[0].length == 0)
				return 0;
			int count = 0;
			boolean[][] visited = new boolean[grid.length][grid[0].length];
			for (int row = 0; row < grid.length; row++) {
				for (int col = 0; col < grid[0].length; col++) {
					if (isUnvisitedIsland(grid, visited, row, col)) {
						dfs(grid, visited, row, col);
						count++;
					}
				}
			}
			return count;
		}

		private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
			if (!isUnvisitedIsland(grid, visited, row, col))
				return;
			visited[row][col] = true;
			dfs(grid, visited, row + 1, col);
			dfs(grid, visited, row - 1, col);
			dfs(grid, visited, row, col + 1);
			dfs(grid, visited, row, col - 1);
		}

		private boolean isUnvisitedIsland(char[][] grid, boolean[][] visited, int row, int col) {
			return isValid(grid, row, col) && isIsland(grid, row, col) && !visited[row][col];
		}

		private boolean isIsland(char[][] grid, int row, int col) {
			return grid[row][col] == '1';
		}

		private boolean isValid(char[][] grid, int row, int col) {
			return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
		}

	}

	// BFS
	// Time Limit Exceeded
	public class Solution2 {

		public int numIslands(char[][] grid) {
			if (grid == null || grid.length == 0 || grid[0].length == 0)
				return 0;
			int count = 0;
			boolean[][] visited = new boolean[grid.length][grid[0].length];
			for (int row = 0; row < grid.length; row++) {
				for (int col = 0; col < grid[0].length; col++) {
					if (isUnvisitedIsland(grid, visited, row, col)) {
						bfs(grid, visited, row, col);
						count++;
					}
				}
			}
			return count;
		}

		private void bfs(char[][] grid, boolean[][] visited, int row, int col) {
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] { row, col });
			while (!queue.isEmpty()) {
				int[] current = queue.poll();
				visited[current[0]][current[1]] = true;
				addIslandToQueue(queue, grid, visited, current[0] - 1, current[1]);
				addIslandToQueue(queue, grid, visited, current[0] + 1, current[1]);
				addIslandToQueue(queue, grid, visited, current[0], current[1] - 1);
				addIslandToQueue(queue, grid, visited, current[0], current[1] + 1);
			}
		}

		private void addIslandToQueue(Queue<int[]> queue, char[][] grid, boolean[][] visited, int row, int col) {
			if (isUnvisitedIsland(grid, visited, row, col)) {
				queue.add(new int[] { row, col });
			}
		}

		private boolean isUnvisitedIsland(char[][] grid, boolean[][] visited, int row, int col) {
			return isValid(grid, row, col) && isIsland(grid, row, col) && !visited[row][col];
		}

		private boolean isIsland(char[][] grid, int row, int col) {
			return grid[row][col] == '1';
		}

		private boolean isValid(char[][] grid, int row, int col) {
			return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
		}

	}

}
