package org.deb.codesignal.practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUtilTest {

    ArrayUtil arrayUtil = new ArrayUtil();

    @Test
    public void testCountDistantPairs(){
        assertEquals(3,arrayUtil.countDistantPairs("abacaba",1));
        assertEquals(3,arrayUtil.countDistantPairs("abacaba",3));
    }

}