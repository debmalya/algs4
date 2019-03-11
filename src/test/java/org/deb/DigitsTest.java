package org.deb;

import org.junit.Test;

import static org.junit.Assert.*;

public class DigitsTest {

    Digits digits = new Digits();

    @Test
    public void digitDifferenceSort() {
        int[] a = new int[]{152, 23, 7, 887, 243};
        int[] e = new int[]{7, 887, 23, 243, 152};
        assertArrayEquals(e,digits.digitDifferenceSort(a));
    }

    @Test
    public void getD() {
        assertEquals(4,digits.getD(154));
        assertEquals(1,digits.getD(23));
        assertEquals(0,digits.getD(7));
        assertEquals(1,digits.getD(887));
        assertEquals(2,digits.getD(243));
    }
}