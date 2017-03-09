package org.dzhou.leetcode;

/**
 * 531. Lonely Pixel I
 * 
 * Given a picture consisting of black and white pixels, find the number of
 * black lonely pixels.
 * 
 * The picture is represented by a 2D char array consisting of 'B' and 'W',
 * which means black and white pixels respectively.
 * 
 * A black lonely pixel is character 'B' that located at a specific position
 * where the same row and same column don't have any other black pixels.
 * 
 * Example: Input:
 * 
 * [['W', 'W', 'B'], <br>
 * ['W', 'B', 'W'],<br>
 * ['B', 'W', 'W']]<br>
 * 
 * Output: 3
 * 
 * Explanation: All the three 'B's are black lonely pixels.
 * 
 * @author zhoudong
 *
 */
public class LonelyPixelI {

	public int findLonelyPixel(char[][] picture) {

		int[] rowCount = new int[picture.length];
		int[] colCount = new int[picture[0].length];

		for (int row = 0; row < picture.length; row++) {
			for (int col = 0; col < picture[0].length; col++) {
				if (picture[row][col] == 'B') {
					rowCount[row]++;
					colCount[col]++;
				}
			}
		}

		int count = 0;
		for (int row = 0; row < picture.length; row++) {
			for (int col = 0; col < picture[0].length; col++) {
				if (picture[row][col] == 'B' && rowCount[row] == 1 && colCount[col] == 1) {
					count++;
				}
			}
		}

		return count;
	}

}
