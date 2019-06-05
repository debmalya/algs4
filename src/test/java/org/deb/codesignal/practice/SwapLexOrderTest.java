package org.deb.codesignal.practice;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class SwapLexOrderTest {

    SwapLexOrder swapLexOrder = new SwapLexOrder();

    @Test
    public void swapLexOrder() {
        assertEquals("dbca",swapLexOrder.swapLexOrder("abdc",new int[][]{{1,4},{3,4}}));
        assertEquals("dbcaefhg",swapLexOrder.swapLexOrder("abcdefgh",new int[][]{{1,4},{7,8}}));
        assertEquals("z",swapLexOrder.swapLexOrder("z",new int[0][0]));
        assertEquals("zdsnxamwoj",swapLexOrder.swapLexOrder("dznsxamwoj",new int[][]{{1,2},{3,4},{6,5},{8,10}}));
        assertEquals("zdsnxamwoj",swapLexOrder.swapLexOrder("dznsxamwoj",new int[][]{{1,2},{3,4},{6,5},{8,10}}));
        assertEquals("zdxrabca",swapLexOrder.swapLexOrder("acxrabdz",new int[][]{{1,3},{6,8},
                {3,8},{2,7}}));

    }

    @Test
    public void testPositionMap(){
        Map<Integer, Set<Integer>> pMap = new HashMap<>();
        swapLexOrder.mapPositions(pMap,1,3);
        swapLexOrder.mapPositions(pMap,3,1);
        assertTrue(pMap.get(1).contains(3));
        assertTrue(pMap.get(3).contains(1));

        swapLexOrder.mapPositions(pMap,6,8);
        swapLexOrder.mapPositions(pMap,8,6);
        assertTrue(pMap.get(6).contains(8));
        assertTrue(pMap.get(8).contains(6));


        swapLexOrder.mapPositions(pMap,3,8);
        swapLexOrder.mapPositions(pMap,8,3);

        assertTrue(pMap.get(8).contains(3));
        assertTrue(pMap.get(8).contains(1));
        assertTrue(pMap.get(3).contains(8));

        swapLexOrder.mapPositions(pMap,2,7);
        swapLexOrder.mapPositions(pMap,7,2);
        assertTrue(pMap.get(2).contains(7));
        assertTrue(pMap.get(7).contains(2));
        System.out.println(pMap);
    }

    @Test
    public void testCharacterPosition(){
        Map<Character,List<Integer>> cMap = swapLexOrder.createCharacterMap("acxrabdz".toCharArray());
        assertEquals(1,cMap.get('a').get(0).intValue());
        assertEquals(5,cMap.get('a').get(1).intValue());
        assertEquals(6,cMap.get('b').get(0).intValue());
        assertEquals(2,cMap.get('c').get(0).intValue());
        assertEquals(7,cMap.get('d').get(0).intValue());
        assertEquals(4,cMap.get('r').get(0).intValue());
        assertEquals(3,cMap.get('x').get(0).intValue());
        assertEquals(8,cMap.get('z').get(0).intValue());
    }
}