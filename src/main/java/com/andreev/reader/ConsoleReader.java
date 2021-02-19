package com.andreev.reader;

import java.util.Scanner;

public class ConsoleReader {
    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleReader() {
    }

    public static String readLine() {
        return SCANNER.nextLine();
    }
}
