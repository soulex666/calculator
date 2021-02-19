package com.andreev.provider;

import java.math.BigInteger;
import java.util.List;

public class MathOperationProviderImpl implements MathOperationProvider {
    private static final String STRING_NUMBER_ZERO = "0";

    @Override
    public BigInteger provideOperation(List<Long> numbers) {
        BigInteger integer = BigInteger.valueOf(numbers.get(2));
        BigInteger secondNumber = BigInteger.valueOf(numbers.get(3));

        if (numbers.get(0).equals(0L)) {
            return integer.add(secondNumber);
        } else if (numbers.get(0).equals(1L)) {
            return integer.subtract(secondNumber);
        } else if (numbers.get(0).equals(2L)) {
            return integer.multiply(secondNumber);
        }

        if (secondNumber.toString().equals(STRING_NUMBER_ZERO)) {
            throw new IllegalArgumentException("The divider is zero");
        }
        return integer.divide(secondNumber);
    }
}
