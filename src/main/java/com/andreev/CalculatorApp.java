package com.andreev;

import com.andreev.converter.ConverterNumbersImpl;
import com.andreev.parser.ParserImpl;
import com.andreev.provider.CalculatorProvider;
import com.andreev.provider.CalculatorProviderImpl;
import com.andreev.provider.MathOperationProviderImpl;
import com.andreev.provider.ViewProviderImpl;
import com.andreev.validator.ValidatorImpl;

public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorProvider provider = new CalculatorProviderImpl(
                new ValidatorImpl(),
                new ViewProviderImpl(),
                new ParserImpl(),
                new MathOperationProviderImpl(),
                new ConverterNumbersImpl());

        provider.run();
    }
}
