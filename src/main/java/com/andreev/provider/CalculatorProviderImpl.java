package com.andreev.provider;

import com.andreev.converter.ConverterNumbers;
import com.andreev.parser.Parser;
import com.andreev.reader.ConsoleReader;
import com.andreev.validator.Validator;

import java.math.BigInteger;
import java.util.List;

public class CalculatorProviderImpl implements CalculatorProvider {
    private final Validator validator;
    private final ViewProvider viewProvider;
    private final Parser parser;
    private final MathOperationProvider mathProvider;
    private final ConverterNumbers converterNumbers;

    public CalculatorProviderImpl(Validator validator,
                                  ViewProvider viewProvider,
                                  Parser parser,
                                  MathOperationProvider mathProvider,
                                  ConverterNumbers converterNumbers) {

        this.validator = validator;
        this.viewProvider = viewProvider;
        this.parser = parser;
        this.mathProvider = mathProvider;
        this.converterNumbers = converterNumbers;
    }

    @Override
    public void run() {
        while (true) {
            viewProvider.provideView("Enter the sentence or 'exit' for exit from the application");
            String text = ConsoleReader.readLine();

            if (text.equals("exit")) {
                break;
            }

            validator.validate(text);

            List<Long> numbers = parser.parseToNumber(text);

            BigInteger bigInteger = mathProvider.provideOperation(numbers);

            String result = bigInteger.toString();

            if (numbers.get(1) == 1L) {
                validator.validateRomanResult(result);
                result = converterNumbers.convertFromArabicToRoman(result);
            }

            viewProvider.provideView(result);
        }
    }
}
