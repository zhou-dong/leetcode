package org.dzhou.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 529. Minesweeper
 * 
 * @author zhoudong
 *
 */
public class Minesweeper {

	public char[][] updateBoard(char[][] board, int[] click) {
		int row = click[0], col = click[1];

		if (board[row][col] == 'M') {
			board[row][col] = 'X';
			return board;
		}

		int count = countAdjacentMine(board, row, col);
		if (count > 0) { // If it is not a 'B', stop further DFS.
			board[row][col] = (char) (count + '0');
			return board;
		}

		// Continue DFS to adjacent cells.
		board[row][col] = 'B';
		for (int[] direction : directions()) {
			int[] next = { row + direction[0], col + direction[1] };
			if (!isValid(board, next)) {
				continue;
			}
			if (board[next[0]][next[1]] == 'E') {
				updateBoard(board, next);
			}
		}
		return board;
	}

	private int countAdjacentMine(char[][] board, int row, int col) {
		int count = 0;
		for (int[] direction : directions()) {
			if (isMine(board, row + direction[0], col + direction[1])) {
				count++;
			}
		}
		return count;
	}

	private Set<int[]> directions() {
		Set<int[]> directions = new HashSet<>();
		for (int row = -1; row < 2; row++) {
			for (int col = -1; col < 2; col++) {
				if (row == 0 && col == 0) {
					continue;
				}
				directions.add(new int[] { row, col });
			}
		}
		return directions;
	}

	private boolean isMine(char[][] board, int row, int col) {
		if (!isValid(board, row, col)) {
			return false;
		}
		if (board[row][col] == 'M' || board[row][col] == 'X') {
			return true;
		} else {
			return false;
		}
	}

	private boolean isValid(char[][] board, int[] position) {
		return isValid(board, position[0], position[1]);
	}

	private boolean isValid(char[][] board, int row, int col) {
		return row >= 0 && col >= 0 && row < board.length && col < board[row].length;
	}

}
