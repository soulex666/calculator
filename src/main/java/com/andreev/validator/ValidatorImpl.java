package com.andreev.validator;

public class ValidatorImpl implements Validator {
    private static final String SPACE_DELIMITER = " ";

    @Override
    public void validate(String string) {
        String [] numbers = string.split(SPACE_DELIMITER);

        if (numbers.length != 3 || numbers[0].length() > 11 ||
                numbers[2].length() > 11 || !numbers[1].matches("[-/+*]")) {

            throw new IllegalArgumentException("The sentence is incorrect");
        }

        if (!((numbers[0].matches("-?[\\d]+") && numbers[2].matches("-?[\\d]+")) ||
                (numbers[0].matches("[IVXLCDM]+") && numbers[2].matches("[IVXLCDM]+"))) ) {

            throw new IllegalArgumentException("The number is incorrect");
        }
    }

    @Override
    public void validateRomanResult(String result) {
        int intValue = 0;

        try {
            intValue = Integer.parseInt(result);
        } catch (NumberFormatException ignored) {}

        if ((intValue <= 0) || (intValue > 4000)) {
            throw new IllegalArgumentException(result + " is not in range (0,4000)");
        }
    }
}
