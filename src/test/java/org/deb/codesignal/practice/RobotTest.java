package org.deb.codesignal.practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {

    Robot robot = new Robot();

    @Test
    public void robotWalk() {
        Robot robot = new Robot();
        assertTrue(robot.robotWalk(new int[]{4, 4, 3, 2, 2, 3}));
        assertTrue(robot.robotWalk(new int[]{7, 5, 4, 5, 2, 3}));
        assertFalse(robot.robotWalk(new int[]{10, 3, 10, 2, 5, 1, 2}));
        assertTrue(robot.robotWalk(new int[]{11, 8, 6, 6, 4, 3, 7, 2, 1}));
        assertFalse(robot.robotWalk(new int[]{34241, 23434, 2341}));
        assertTrue(robot.robotWalk(new int[]{1000, 5, 5, 6, 6, 100}));
        assertFalse(robot.robotWalk(new int[]{1000, 5, 5, 4, 4, 3}));
        assertTrue(robot.robotWalk(new int[]{100000, 100000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000}));
        assertFalse(robot.robotWalk(new int[]{100000, 100000, 10000, 1000, 1000, 100, 100, 10, 10, 5}));
        assertTrue(robot.robotWalk(new int[]{5, 5, 5, 5}));
    }

    @Test
    public void checkValidity(){
        assertTrue(robot.robotWalk(new int[]{5, 5, 5, 5}));
    }
}
