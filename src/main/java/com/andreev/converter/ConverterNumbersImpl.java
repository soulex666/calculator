package com.andreev.converter;

import java.util.List;

public class ConverterNumbersImpl implements ConverterNumbers {

    @Override
    public String convertFromArabicToRoman(String number) {
        int intValue = Integer.parseInt(number);
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (intValue > 0 && i < romanNumerals.size()) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= intValue) {
                sb.append(currentSymbol.name());
                intValue -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
