package com.shpp.p2p.cs.ynamurovanyi.assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part1 extends KarelTheRobot {

    /*main method*/
    public void run() throws Exception {
        MoveToTarget();
        pickBeeper();
        ReturnToStart();
    }

    /*move to newspaper*/
    private void MoveToTarget() throws Exception {
        turnRight();
        move();
        turnLeft();
        move();
        move();
        move();
        move();
    }

    /*define new method*/
    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /*return to starting position*/
    private void ReturnToStart() throws Exception {
        turnLeft();
        turnLeft();
        move();
        move();
        move();
        move();
        turnRight();
        move();
        turnRight();
    }

}
