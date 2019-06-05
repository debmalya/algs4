package org.deb.codesignal.practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class CloudTest {

    Cloud cloud = new Cloud();

    @Test
    public void countClouds() {
        char[][] arr = new char[][]{{'1', '1', '0', '1', '0', '1'}};
        assertEquals(3, cloud.countClouds(arr));

        arr = new char[][]{{'0', '1', '0', '0', '1'}};
        assertEquals(2, cloud.countClouds(arr));

        arr = new char[][]{{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}};
        assertEquals(3, cloud.countClouds(arr));

        arr = new char[][]{{}};
        assertEquals(0, cloud.countClouds(arr));

        arr = new char[][]{{1}};
        assertEquals(1, cloud.countClouds(arr));

        arr = new char[][]{{'1','1','1'},{'0','1','0'},{'0','1','0'}};
        assertEquals(1, cloud.countClouds(arr));

        arr = new char[][]{{'0','1','1','0','1'}};
        assertEquals(2,cloud.countClouds(arr));

        arr = new char[][]{{'0','1','1','0','1'},{'0','1','1','1','1'}};
        assertEquals(1,cloud.countClouds(arr));
    }
}