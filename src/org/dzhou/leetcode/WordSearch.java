package org.dzhou.leetcode;

/**
 * 79. Word Search
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example,<br>
 * Given board =
 * 
 * [ <br>
 * --['A','B','C','E'], <br>
 * --['S','F','C','S'], <br>
 * --['A','D','E','E'] <br>
 * ] <br>
 * 
 * word = "ABCCED", -> returns true, <br>
 * word = "SEE", -> returns true, <br>
 * word = "ABCB", -> returns false. <br>
 * 
 * @author zhoudong
 *
 */
public class WordSearch {

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return false;
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (exist(board, word, row, col, 0, new boolean[board.length][board[0].length])) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean exist(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
		if (index == word.length()) {
			return true;
		}

		if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || visited[row][col]) {
			return false;
		}

		if (board[row][col] != word.charAt(index)) {
			return false;
		}

		visited[row][col] = true;

		boolean result = exist(board, word, row, col - 1, index + 1, visited)
				|| exist(board, word, row, col + 1, index + 1, visited)
				|| exist(board, word, row - 1, col, index + 1, visited)
				|| exist(board, word, row + 1, col, index + 1, visited);

		visited[row][col] = false;

		return result;
	}

}
