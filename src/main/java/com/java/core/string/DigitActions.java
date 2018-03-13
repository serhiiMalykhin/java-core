package com.java.core.string;

public class DigitActions {

    public String plusStringIntegerDigits(String firstStringDigit, String secondStringDigit) {
        char[] charsFirstDigit = firstStringDigit.toCharArray();
        char[] charsSecondDigit = secondStringDigit.toCharArray();
        int firstDigit = extractIntDigit(charsFirstDigit);
        int secondDigit = extractIntDigit(charsSecondDigit);
        return String.valueOf(firstDigit + secondDigit);
    }

    private int extractIntDigit(char[] digitChars) {
        boolean isNegativeDigit = false;
        int firstDigit = 0;
        for (int i = 0, exponent = digitChars.length - 1; i < digitChars.length; i++, exponent--) {
            if (i == 0 && digitChars[i] == '-') {
                isNegativeDigit = true;
                continue;
            }
            firstDigit += (digitChars[i] - 48) * Math.pow(10, exponent);
        }
        if (isNegativeDigit) {
            firstDigit *= -1;
        }
        return firstDigit;
    }

    public String plusStringDoubleDigits(String firstStringDigit, String secondStringDigit) {
        char[] charsFirstDigit = firstStringDigit.toCharArray();
        char[] charsSecondDigit = secondStringDigit.toCharArray();
        double firstDigit = extractDoubleDigit(charsFirstDigit);
        double secondDigit = extractDoubleDigit(charsSecondDigit);
        return String.valueOf(firstDigit + secondDigit);

    }

    private double extractDoubleDigit(char[] digitChars) {
        boolean isNegativeDigit = false;
        double firstDigit = 0;
        long asciiCodeZero = 48;
        long findCommaPlace = 1;
        boolean isCommaFound = false;
        for (int i = 0, exponent = digitChars.length - 1; i < digitChars.length; i++, exponent--) {
            char charDigit = digitChars[i];
            if (i == 0 && charDigit == '-') {
                isNegativeDigit = true;
                continue;
            }
            if (charDigit == '.' || charDigit == 'D' || charDigit == 'd') {
                if (!isCommaFound) {
                    isCommaFound = true;
                    findCommaPlace = (long) (findCommaPlace * Math.pow(10, (digitChars.length - 1 - i)));
                    firstDigit /= 10;
                }
                continue;
            }
            firstDigit += (digitChars[i] - asciiCodeZero) * Math.pow(10, exponent);
        }
        if (isNegativeDigit) {
            firstDigit *= -1;
        }
        return firstDigit / findCommaPlace;
    }

}
