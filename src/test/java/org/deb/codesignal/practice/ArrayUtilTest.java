package org.deb.codesignal.practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUtilTest {

    ArrayUtil arrayUtil = new ArrayUtil();

    @Test
    public void testCountDistantPairs() {
        assertEquals(3, arrayUtil.countDistantPairs("abacaba", 1));
        assertEquals(3, arrayUtil.countDistantPairs("abacaba", 3));
    }

    @Test
    public void testSimplifyPath() {
        assertEquals("/home/a/b/c", ArrayUtil.simplifyPath("/home/a/./x/../b//c/"));
        assertEquals("/", ArrayUtil.simplifyPath("/../"));
    }

    @Test
    public void testDecodedString() {
        assertEquals("abababab", arrayUtil.decodeString("4[ab]"));
        assertEquals("baaabaaa", arrayUtil.decodeString("2[b3[a]]]"));
        assertEquals("accaccacc", arrayUtil.decodeString("3[a2[c]]"));
        assertEquals("bbbbbbbbbbbbbbbb", arrayUtil.decodeString("2[2[2[2[b]]]]"));
        assertEquals("aaabcbc", arrayUtil.decodeString("3[a]2[bc]"));
        assertEquals("zyzzzabcabc", arrayUtil.decodeString("z1[y]zzz2[abc]"));
        assertEquals("abcabccdcdcdef", arrayUtil.decodeString("2[abc]3[cd]ef"));
        assertEquals("codesignalcodesignalcodesignalcodesignalcodesignalcodesignalcodesignalcodesignalcodesignalcodesignal", arrayUtil.decodeString("10[codesignal]"));
        assertEquals("feeg", arrayUtil.decodeString("f2[e]g"));
//        assertEquals("feegfeeg",arrayUtil.decodeString("2[f2[e]g]"));
//        assertEquals("sdfeegfeegi",arrayUtil.decodeString("sd2[f2[e]g]i"));
    }

    @Test
    public void testReverseStringInParanthesis() {
        assertEquals("rab", arrayUtil.reverseInParentheses("(bar)"));
        assertEquals("foorabbaz", arrayUtil.reverseInParentheses("foo(bar)baz"));
        assertEquals("foorabbaz", arrayUtil.reverseInParentheses("foo(bar)baz"));
    }

    @Test
    public void camelCase() {
        assertFalse(arrayUtil.camelCaseSeparation(new String[]{"paxltbm",
                "hhbut",
                "ehqn",
                "odqetasf",
                "zt"}, "lg"));

        assertFalse(arrayUtil.camelCaseSeparation(new String[]{"rmgeydubej"},
                "RmgeydubejRmgeydubejbgsozjgoRmgeydubej"));
    }

    @Test
    public void testSmallestUnusalNumber() {
        assertEquals(8, arrayUtil.smallestUnusualNumber("42"));
        assertEquals(0, arrayUtil.smallestUnusualNumber("1000000000000000000000000000000000000"));
        assertEquals(2, arrayUtil.smallestUnusualNumber("8888888888888888888888888888888"));
        assertEquals(9, arrayUtil.smallestUnusualNumber("1"));
        assertEquals(0, arrayUtil.smallestUnusualNumber("102"));
        assertEquals(0, arrayUtil.smallestUnusualNumber("130"));
        assertEquals(0, arrayUtil.smallestUnusualNumber("131"));
        assertEquals(0, arrayUtil.smallestUnusualNumber("161"));
        assertEquals(0, arrayUtil.smallestUnusualNumber("150"));
        assertEquals(8, arrayUtil.smallestUnusualNumber("132"));
        assertEquals(5, arrayUtil.smallestUnusualNumber("155"));
        assertEquals(9, arrayUtil.smallestUnusualNumber("991"));
        for (int i = 200; i < 212; i++) {
            assertEquals(0, arrayUtil.smallestUnusualNumber(String.valueOf(i)));
        }
        assertEquals(0, arrayUtil.smallestUnusualNumber("212"));
    }

    @Test
    public void testComb() {
        assertEquals(5, arrayUtil.combs("*...*", "*.*"));
        assertEquals(6, arrayUtil.combs("*..*.*", "*.*"));
        assertEquals(5, arrayUtil.combs("*..*", "*.*"));
        assertEquals(5, arrayUtil.combs("*.**", "*.*"));
        assertEquals(4, arrayUtil.combs("*.*", "*.*"));
        assertEquals(4, arrayUtil.combs("*.*", "*.*"));

        assertEquals(9, arrayUtil.combs("*..*.*", "*.***"));
        assertEquals(7, arrayUtil.combs("*..*.*", "*..*.*"));
        assertEquals(7, arrayUtil.combs("*..*.*", "*..*.*"));
        assertEquals(7, arrayUtil.combs("*..*.*", "*.*..*"));

    }

    @Test
    public void testChar26() {
        assertEquals("th", arrayUtil.cipher26("ta"));
        assertEquals("thi", arrayUtil.cipher26("tai"));
        assertEquals("taiaiaertkixquxjnfxxdh",arrayUtil.decipher26("thisisencryptedmessage"));
        assertEquals("thisisencryptedmessage", arrayUtil.cipher26("taiaiaertkixquxjnfxxdh"));
    }
}