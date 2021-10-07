package com.learningjava.nullobject;

import org.junit.Test;

public class Main {
    @Test
    public void singleCallTest() throws Exception {
        Account a = new Account(new NullLog());
        a.someOperation();
    }

    @Test
    public void manyCallsTest() throws Exception {
        Account a = new Account(new NullLog());
        for (int i = 0; i < 100; ++i)
            a.someOperation();
    }
}
