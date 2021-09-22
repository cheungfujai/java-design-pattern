package com.learningjava.singleton;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class Main {
    @Test
    public void test()
    {
        Object obj = new Object();
        assertTrue(SingletonTester.isSingleton(() -> obj));
        assertFalse(SingletonTester.isSingleton(Object::new));
    }
}
