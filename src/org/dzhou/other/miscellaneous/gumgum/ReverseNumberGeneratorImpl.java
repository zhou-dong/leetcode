package org.dzhou.other.miscellaneous.gumgum;

public class ReverseNumberGeneratorImpl implements ReverseNumberGenerator {

	@Override
	public Integer reverseANumber(Integer number) {
		boolean isNegative = false;
		if (number < 0) {
			isNegative = true;
			number = 0 - number;
		}
		int result = 0;
		while (number > 0) {
			result = result * 10 + number % 10;
			number /= 10;
		}
		if (result < 0)
			throw new RuntimeException(
					"This number is too larger if we reserve the number will be larger then the max of the integer:"
							+ number);
		return isNegative ? (0 - result) : result;
	}

}
