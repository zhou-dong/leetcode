package org.dzhou.other.rubicon;

import java.util.HashMap;
import java.util.Map;

public class SparseMatrixEncodeKey implements SparseMatrix {

	Map<Integer, Integer> matrix;

	private int size;

	public SparseMatrixEncodeKey(int size) {
		matrix = new HashMap<>();
		this.size = size;
	}

	@Override
	public void insert(int row, int col, int value) {
		matrix.put(encodeKey(row, col), value);
	}

	@Override
	public int get(int row, int col) {
		int key = encodeKey(row, col);
		return matrix.containsKey(key) ? matrix.get(key) : 0;
	}

	private int encodeKey(int row, int col) {
		return row * size + col;
	}

}
