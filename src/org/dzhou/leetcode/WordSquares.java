package org.dzhou.leetcode;

import java.util.List;

/**
 * 425. Word Squares
 * 
 * Difficulty: Hard
 * 
 * Given a set of words (without duplicates), find all word squares you can
 * build from them.
 * 
 * A sequence of words forms a valid word square if the kth row and column read
 * the exact same string, where 0 ≤ k < max(numRows, numColumns).
 * 
 * For example, the word sequence ["ball","area","lead","lady"] forms a word
 * square because each word reads the same both horizontally and vertically.
 * 
 * b a l l <br>
 * a r e a <br>
 * l e a d <br>
 * l a d y <br>
 * 
 * Note: <br>
 * There are at least 1 and at most 1000 words. <br>
 * All words will have the exact same length. <br>
 * Word length is at least 1 and at most 5. <br>
 * Each word contains only lowercase English alphabet a-z. <br>
 * 
 * Example 1:
 * 
 * Input: <br>
 * ["area","lead","wall","lady","ball"]
 * 
 * Output: <br>
 * [ <br>
 * --[ "wall", <br>
 * ----"area", <br>
 * ----"lead", <br>
 * ----"lady" <br>
 * --], <br>
 * --[ "ball", <br>
 * ----"area", <br>
 * ----"lead", <br>
 * ----"lady" <br>
 * --] <br>
 * ] <br>
 * 
 * Explanation: The output consists of two word squares. The order of output
 * does not matter (just the order of words in each word square matters).
 * 
 * Example 2:
 * 
 * Input: <br>
 * ["abat","baba","atan","atal"]
 * 
 * Output: <br>
 * [ <br>
 * --[ "baba", <br>
 * ----"abat", <br>
 * ----"baba", <br>
 * ----"atan" <br>
 * --], <br>
 * --[ "baba", <br>
 * ----"abat", <br>
 * ----"baba", <br>
 * ----"atal" <br>
 * --] <br>
 * ] <br>
 * 
 * Explanation: The output consists of two word squares. The order of output
 * does not matter (just the order of words in each word square matters). Show
 * Company Tags Show Tags Show Similar Problems
 * 
 * @author zhoudong
 *
 *         Solution: Backtracking + Trie
 *
 */
public class WordSquares {

	class TrieNode {

	}

	class Trie {

	}

	public List<List<String>> wordSquares(String[] words) {

		return null;
	}

}
