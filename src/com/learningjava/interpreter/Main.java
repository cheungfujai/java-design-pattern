package com.learningjava.interpreter;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Main {
    @Test
    public void test() {
        ExpressionProcessor ep = new ExpressionProcessor();
        ep.variables.put('x', 5);

        assertEquals(1, ep.calculate("1"));
        assertEquals(3, ep.calculate("1+2"));
        assertEquals(6, ep.calculate("1+x"));
        assertEquals(0, ep.calculate("1+xy"));
    }
}
