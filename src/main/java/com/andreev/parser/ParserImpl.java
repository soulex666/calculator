package com.andreev.parser;

import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final String SPACE_DELIMITER = " ";

    @Override
    public List<Long> parseToNumber(String sentence) {
        String [] numbers = sentence.split(SPACE_DELIMITER);
        List<Long> parsedNumbers = new ArrayList<>();

        parsedNumbers.add(getMathSign(numbers[1]));

        if(numbers[0].matches("-?[\\d]+")) {
            parsedNumbers.add(0L);
            parsedNumbers.add(Long.parseLong(numbers[0]));
            parsedNumbers.add(Long.parseLong(numbers[2]));
        } else {
            parsedNumbers.add(1L);
            parsedNumbers.add(parseFromRoman(numbers[0]));
            parsedNumbers.add(parseFromRoman(numbers[2]));
        }

        return parsedNumbers;
    }

    private long parseFromRoman(String numbers) {
        long decimal = 0;
        long romanNumber;
        long prev = 0;
        for (int i = numbers.length() - 1; i >= 0; i--){
            romanNumber = getLongFromChar(numbers.charAt(i));

            if (romanNumber < decimal && romanNumber != prev ) {
                decimal -= romanNumber;
            } else {
                decimal += romanNumber;
            }
            prev = romanNumber;
        }

        return decimal;
    }

    private long getLongFromChar(char ch) {
        if (ch == 'V') {
            return 5L;
        }
        if (ch == 'I') {
            return 1L;
        }
        if (ch == 'X') {
            return 10L;
        }
        if (ch == 'L') {
            return 50L;
        }
        if (ch == 'C') {
            return 100L;
        }
        if (ch == 'D') {
            return 500L;
        }
        return 1000L;
    }

    private long getMathSign(String sign) {
        if (sign.equals("+")) {
            return 0L;
        }
        if (sign.equals("-")) {
            return 1L;
        }
        if (sign.equals("*")) {
            return 2L;
        }
        return 3L;
    }
}
