package com.learningjava.structural.composite;

import java.util.ArrayList;
import java.util.Collection;

public class MyList extends ArrayList<ValueContainer> {
    public MyList(Collection<? extends ValueContainer> c) {
        super(c);
    }

    public int sum(){
        int result = 0;
        for(ValueContainer v : this){
            for(int value : v) result += value;
        }
        return result;
    }
}
