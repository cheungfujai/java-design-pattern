package com.learningjava.state;

public class CombinationLock {

    private int [] combination;
    public String status;
    private int index;
    private boolean fail = false;

    public CombinationLock(int[] combination) {
        this.combination = combination;
        reset();
    }

    public void reset(){
        status = "LOCKED";
        index = 0;
        fail = false;
    }

    // todo: check digit and update status here
    public void enterDigit(int digit) {
        if(status == "LOCKED") status = "";
        status += digit;

        if(combination[index] != digit) fail = true;
        index++;

        if(combination.length == index) status = fail ? "ERROR" : "OPEN";
    }
}
