package com.shpp.p2p.cs.ynamurovanyi.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part2 extends KarelTheRobot {
    public void run() throws Exception {

        /*repair first column*/
        fixColumn();

        /*check if next column exists*/
        if (frontIsClear())

            /*move to next column and repair*/
            fixNextColumn();
    }

    /*repair column and move to it's bottom*/
    private void fixColumn() throws Exception {

        /*repair*/
        turnLeft();
        while (frontIsClear()) {
            if (noBeepersPresent()) putBeeper();
            move();
        }
        if (noBeepersPresent()) putBeeper();

        /*move to the bottom*/
        turnLeft();
        turnLeft();
        while (frontIsClear()) move();
        turnLeft();
    }

    /*move to next column and repair*/
    private void fixNextColumn() throws Exception {
        move();
        move();
        move();
        move();
        run();
    }
}
