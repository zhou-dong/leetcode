package org.dzhou.other.rubicon;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SparseMatrixKeyClass implements SparseMatrix {

	class Key {
		int row, col;

		Key(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public int hashCode() {
			return Objects.hash(row, col);
		}

		@Override
		public boolean equals(Object other) {
			return !isKeyClass(other) ? false : equals(this, (Key) other);
		}

		private boolean isKeyClass(Object object) {
			return object != null && (object instanceof Key);
		}

		private boolean equals(Key k1, Key k2) {
			return k1.row == k2.row && k1.col == k2.col;
		}
	}

	Map<Key, Integer> matrix;

	public SparseMatrixKeyClass() {
		matrix = new HashMap<>();
	}

	@Override
	public void insert(int row, int col, int value) {
		matrix.put(new Key(row, col), value);
	}

	@Override
	public int get(int row, int col) {
		Integer value = matrix.get(new Key(row, col));
		return value == null ? 0 : value;
	}

}
