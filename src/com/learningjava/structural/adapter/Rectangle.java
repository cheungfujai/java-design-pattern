package com.learningjava.structural.adapter;

interface Rectangle {
    int getWidth();
    int getHeight();
    default int getArea() {
        return getWidth() * getHeight();
    }
}