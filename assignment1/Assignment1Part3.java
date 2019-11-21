package com.shpp.p2p.cs.ynamurovanyi.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3 extends KarelTheRobot {
    public void run() throws Exception {
        /*check for 1 width world*/
        if (frontIsBlocked()) putBeeper();
        else {
            /*put Beepers on both ends*/
            putEndBeepers();

            /*method name says everything + additional checking for 1 width world*/
            turnAroundAndStep();

            /*additional checking for 2 width world*/
            checkIfMid();

            /*move beepers to the middle step by step on both sides*/
            moveBeepersToMid();
        }
    }

    private void moveBeepersToMid() throws Exception {
        while (frontIsClear()) {
            while (noBeepersPresent()) move();
            pickBeeper();
            turnAround();
            move();
            putBeeper();
            move();
            checkIfMid();
        }
    }

    /*if beepers are next to each other picks one beeper and steps on another + turns down (south) to stop the cycle*/
    private void checkIfMid() throws Exception {
        if (beepersPresent()) {
            pickBeeper();
            turnAround();
            move();
            if (facingEast()) turnRight();
            if (facingWest()) turnLeft();
        }
    }

    private void turnAroundAndStep() throws Exception {
        turnAround();

        if (frontIsClear()) //safety check for 1 width world
            move();
    }

    /*put Beepers on both ends*/
    private void putEndBeepers() throws Exception {
        putBeeper();
        while (frontIsClear()) move();
            putBeeper();
    }

    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

}
