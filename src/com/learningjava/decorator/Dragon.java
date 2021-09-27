package com.learningjava.decorator;

public class Dragon {
    private int age;
    private Bird bird = new Bird();
    private Lizard lizard = new Lizard();

    public void setAge(int age) {
        this.age = age;
        this.bird.age = age;
        this.lizard.age = age;
    }
    public String fly() {
        return bird.fly();
    }
    public String crawl() {
        return lizard.crawl();
    }
}
