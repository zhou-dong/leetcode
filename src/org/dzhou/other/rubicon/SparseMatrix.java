package org.dzhou.other.rubicon;

/**
 * @author zhoudong
 */
public interface SparseMatrix {

	public void insert(int row, int col, int value);

	public int get(int row, int col);

}
