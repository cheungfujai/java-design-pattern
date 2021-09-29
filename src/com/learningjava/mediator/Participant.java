package com.learningjava.mediator;

public class Participant {

    public int value = 0;
    private Mediator mediator;

    public Participant(Mediator mediator) {
        this.mediator = mediator;
        mediator.addListener(this);
    }

    public void say(int n) {
        mediator.broadcast(this, n);
    }
}
