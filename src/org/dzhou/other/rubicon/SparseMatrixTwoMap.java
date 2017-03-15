package org.dzhou.other.rubicon;

import java.util.HashMap;
import java.util.Map;

public class SparseMatrixTwoMap implements SparseMatrix {

	Map<Integer, Map<Integer, Integer>> matrix;

	public SparseMatrixTwoMap() {
		matrix = new HashMap<>();
	}

	@Override
	public void insert(int row, int col, int value) {
		if (!matrix.containsKey(row))
			matrix.put(row, new HashMap<>());
		matrix.get(row).put(col, value);
	}

	@Override
	public int get(int row, int col) {
		if (!matrix.containsKey(row)) {
			return 0;
		}
		Map<Integer, Integer> cols = matrix.get(row);
		return cols.containsKey(col) ? cols.get(col) : 0;
	}

}
