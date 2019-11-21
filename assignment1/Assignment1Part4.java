package com.shpp.p2p.cs.ynamurovanyi.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part4 extends KarelTheRobot {
    public void run() throws Exception {
        checkWorldType();
    }

    /*check world type and run correct scenario*/
    private void checkWorldType() throws Exception {

        if (frontIsBlocked()) {                             // 1*1 world scenario
            if (leftIsBlocked()) putBeeper();               // place beeper and finish
        }

        if (frontIsBlocked()) {                             // Vertical world scenario
            if (leftIsClear()) { turnLeft(); buildLine(); } // place beepers on vertical line and finish
        }

        if (leftIsBlocked()) {                              // Horizontal world scenario
            if (frontIsClear()) buildLine();                // place beepers on horizontal line and finish
        }

        if (frontIsClear()) {                               // Classic scenario
            if (leftIsClear()) classicWorld();              // run method dedicated to classic world
        }

    }

    /*build one column and continue if not end of the world :D */
    private void classicWorld() throws Exception {
        turnLeft();
        buildLine();                                        // call method to build line
        goBottom();                                         // move to bottom

        if (frontIsClear()) continueBuilding();             // if not end of the world call method to continue
    }

    /*check which type of column needed and run correct scenario*/
    private void continueBuilding() throws Exception {
        if (noBeepersPresent()) {                           // next column will be odd
            move();
            classicWorld();
        }

        else {                                              // next column will be even
            move();
            turnLeft();
            move();
            turnRight();
            classicWorld();
        }
    }

    /*method to build line*/
    private void buildLine() throws Exception {
        putBeeper();
        if (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
                buildLine();
            }
        }
    }

    /*go from top to bottom and turn to east*/
    private void goBottom() throws Exception {
        turnAround();
        while (frontIsClear()) move();
        turnLeft();
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
