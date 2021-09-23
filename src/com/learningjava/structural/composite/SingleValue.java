package com.learningjava.structural.composite;

import java.util.Collections;
import java.util.Iterator;

public class SingleValue implements ValueContainer{
    public int value;
    public SingleValue(int value) {
        this.value = value;
    }
    @Override
    public Iterator<Integer> iterator() {
        return Collections.singleton(value).iterator();
    }
}
