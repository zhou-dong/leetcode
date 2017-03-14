package org.dzhou.other.facebook;

/**
 * 125. Valid Palindrome
 * 
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author zhoudong
 *
 */
public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
		for (int low = 0, high = s.length() - 1; low < high;) {
			if (!Character.isLetterOrDigit(s.charAt(low))) {
				low++;
				continue;
			}
			if (!Character.isLetterOrDigit(s.charAt(high))) {
				high--;
				continue;
			}
			if (!equalsIngoreCase(s.charAt(low), s.charAt(high))) {
				return false;
			}
			low++;
			high--;
		}
		return true;
	}

	private boolean equalsIngoreCase(char ch1, char ch2) {
		return Character.toLowerCase(ch1) == Character.toLowerCase(ch2);
	}

}
