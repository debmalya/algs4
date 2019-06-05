package org.deb.codesignal.practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    StringUtil stringUtil = new StringUtil();

    @Test
    public void buildPalindrome() {
        assertEquals("abcdcba",stringUtil.buildPalindrome("abcdc"));
        assertEquals("abababa",stringUtil.buildPalindrome("ababab"));
    }

    @Test
    public void testIsPalindrome(){
        String s = "madam";
        assertTrue(stringUtil.isPalindrome(s));
        s = "madaam";
        assertFalse(stringUtil.isPalindrome(s));

    }
}