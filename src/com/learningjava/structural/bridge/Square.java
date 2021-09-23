package com.learningjava.structural.bridge;

public class Square extends Shape {
    public Square(Renderer renderer){
        super(renderer);
        name = "Square";
    }
}