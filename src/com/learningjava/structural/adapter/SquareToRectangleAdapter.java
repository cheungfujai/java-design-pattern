package com.learningjava.structural.adapter;

public class SquareToRectangleAdapter implements Rectangle{

    private Square square;

    @Override
    public int getWidth(){
        return square.side;
    }

    @Override
    public int getHeight(){
        return square.side;
    }

    public SquareToRectangleAdapter(Square square) {
        this.square = square;
    }
}
