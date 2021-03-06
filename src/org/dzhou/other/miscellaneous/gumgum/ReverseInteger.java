package org.dzhou.other.miscellaneous.gumgum;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * 
 * Example2: x = -123, return -321
 * 
 * @author zhoudong
 *
 */
public class ReverseInteger implements ReverseNumberGenerator {

	@Override
	public Integer reverseANumber(Integer x) {
		Long result = 0L;
		while (x != 0) {
			result *= 10;
			result += x % 10;
			x /= 10;
		}
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return 0;
		return result.intValue();
	}

}
