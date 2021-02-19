package com.andreev.parser;

import java.util.List;

public interface Parser {
    List<Long> parseToNumber(String sentence);
}
