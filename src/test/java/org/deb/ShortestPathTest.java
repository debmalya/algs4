package org.deb;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ShortestPathTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void fillShortestPaths() {
        char[][] plan = new char[][]{
                {' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' '},
                {' ',' ','s',' ',' '},
                {' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' '}};
        ShortestPath shortestPath = new ShortestPath();
        plan = shortestPath.fillShortestPaths(plan);
        printPlan(plan);

    }

    private void printPlan(char[][] plan){
        for (int i = 0; i<plan.length; i++) {
            System.out.println(Arrays.toString(plan[i]));
        }
    }
}