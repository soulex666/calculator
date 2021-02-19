package com.andreev.provider;

import java.math.BigInteger;
import java.util.List;

public interface MathOperationProvider {
    BigInteger provideOperation(List<Long> numbers);
}
