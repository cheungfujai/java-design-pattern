package com.learningjava.mediator;

import java.util.ArrayList;
import java.util.List;

public class Mediator {
    public List<Participant> res = new ArrayList<>();
    public void broadcast(Object sender, int n){
        for(Participant p : res){
            if(p != sender){
                p.value += n;
            }
        }
    }
    public void addListener(Participant p){
        res.add(p);
    }
}
