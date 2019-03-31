package org.deb.codesignal.practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwapLexOrderTest {

    SwapLexOrder swapLexOrder = new SwapLexOrder();

    @Test
    public void swapLexOrder() {
        assertEquals("dbca",swapLexOrder.swapLexOrder("abdc",new int[][]{{1,4},{3,4}}));
        assertEquals("zdxrabca",swapLexOrder.swapLexOrder0("acxrabdz",new int[][]{{1,3},{6,8},
                {3,8},{2,7}}));
    }
}