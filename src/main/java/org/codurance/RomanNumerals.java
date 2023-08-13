package org.codurance;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumerals {

    private static final Map<Integer, String> map = new LinkedHashMap<>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public static String convert(final Integer arabicNumber) {
        StringBuilder romanNumeral = new StringBuilder();
        final Integer[] remainingValue = {arabicNumber};

        map.forEach((arabicValue, romanSymbol) -> {
            while (remainingValue[0] >= arabicValue) {
                romanNumeral.append(romanSymbol);
                remainingValue[0] -= arabicValue;
            }
        });

        return romanNumeral.toString();
    }
}