package org.deb.codesignal.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DigitUtilTest {
    DigitUtil digitUtil = new DigitUtil();

    @Test
    public void pagesNumberingWithInk() {

        assertEquals(5,digitUtil.pagesNumberingWithInk(1,5));
        assertEquals(22,digitUtil.pagesNumberingWithInk(21,5));
        assertEquals(132,digitUtil.pagesNumberingWithInk(100,100));
        assertEquals(1249,digitUtil.pagesNumberingWithInk(1000,1000));
    }

    @Test
    public void goodSegment(){

        List<Integer> arrList = new ArrayList<>();
        arrList.add(4);
        arrList.add(5);
        arrList.add(4);
        arrList.add(2);
        arrList.add(15);
        assertEquals(5,digitUtil.goodSegment(arrList,1,10));

        arrList.clear();
        arrList.add(37);
        arrList.add(7);
        arrList.add(22);
        arrList.add(15);
        arrList.add(49);
        arrList.add(60);
        assertEquals(14,digitUtil.goodSegment(arrList,3,48));

        arrList.clear();
        arrList.add(7);
        arrList.add(48);
        arrList.add(14);
        arrList.add(33);
        arrList.add(11);
        arrList.add(17);
        arrList.add(50);
        arrList.add(25);
        assertEquals(7,digitUtil.goodSegment(arrList,12,38));

        arrList.clear();
        arrList.add(4);
        arrList.add(8);
        arrList.add(6);
        arrList.add(20);
        arrList.add(12);
        assertEquals(10,digitUtil.goodSegment(arrList,1,30));
    }
}