package org.codurance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsTest {

    @ParameterizedTest
    @CsvSource({
            "1, I",
            "2, II",
            "3, III",
            "4, IV",
            "5, V",
            "6, VI",
            "7, VII",
            "8, VIII",
            "9, IX",
            "10, X",
            "40, XL",
            "90, XC",
            "400, CD",
            "900, CM"
    })
    void mustConvertNumberToRomanNumberSuccessfully(int input, String expected) {
        assertEquals(expected, RomanNumerals.convert(input));
    }

    @Test
    void shouldNotHaveILInResult() {
        assertNotEquals("IL", RomanNumerals.convert(49).substring(0, 2));
    }

    @Test
    void shouldNotHaveICInResult() {
        assertNotEquals("IC", RomanNumerals.convert(99).substring(0, 2));
    }

    @Test
    void shouldNotHaveXDInResult() {
        assertNotEquals("XD", RomanNumerals.convert(490).substring(0, 2));
    }

    @Test
    void shouldNotHaveXMInResult() {
        assertNotEquals("XM", RomanNumerals.convert(990).substring(0, 2));
    }

    @Test
    void shouldConvert3ToIII() {
        assertEquals("III", RomanNumerals.convert(3));
    }

    @Test
    void shouldNotHaveIIIIInResult() {
        assertNotEquals("IIII", RomanNumerals.convert(4));
    }

    @Test
    void shouldConvert30ToXXX() {
        assertEquals("XXX", RomanNumerals.convert(30));
    }

    @Test
    void shouldNotHaveXXXXInResult() {
        assertNotEquals("XXXX", RomanNumerals.convert(40));
    }

    @Test
    void shouldNotHaveVVInResult() {
        assertNotEquals("VV", RomanNumerals.convert(10));
    }

    @Test
    void shouldNotHaveLLInResult() {
        assertNotEquals("LL", RomanNumerals.convert(100));
    }

    @Test
    void shouldNotHaveDDInResult() {
        assertNotEquals("DD", RomanNumerals.convert(1000));
    }
}