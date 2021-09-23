package com.learningjava.structural.bridge;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Main {
    @Test
    public void test()
    {
        assertEquals("Drawing Square as lines",
                new Square(new VectorRenderer()).toString( ));
    }
}
