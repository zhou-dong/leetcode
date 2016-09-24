package org.dzhou.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku
 * 
 * @author zhoudong
 *
 */
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9)
			return false;

		Set<Character> set = new HashSet<>();

		// check for row
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				char c = board[row][col];
				if (c == '.')
					continue;
				if (set.contains(c))
					return false;
				set.add(c);
			}
			set.clear();
		}

		// check for column
		for (int col = 0; col < 9; col++) {
			for (int row = 0; row < 9; row++) {
				char c = board[row][col];
				if (c == '.')
					continue;
				if (set.contains(c))
					return false;
				set.add(c);
			}
			set.clear();
		}

		// check for each sub-grid
		for (int k = 0; k < 9; k++) {
			for (int i = k / 3 * 3; i < k / 3 * 3 + 3; i++) {
				for (int j = (k % 3) * 3; j < (k % 3) * 3 + 3; j++) {
					char c = board[i][j];
					if (c == '.')
						continue;
					if (set.contains(c))
						return false;
					set.add(c);
				}
			}
			set.clear();
		}

		return true;
	}

	@Deprecated
	protected boolean checkSubGrid(int grid, char[][] board) {
		Set<Character> set = new HashSet<>();
		int rowStart = grid / 3 * 3;
		int colStart = grid % 3 * 3;
		for (int row = 0; row < rowStart + 3; row++) {
			for (int col = 0; col < colStart + 3; col++) {
				char c = board[row][col];
				if (c == '.')
					continue;
				if (set.contains(c))
					return false;
				set.add(c);
			}
		}
		return true;
	}

}
