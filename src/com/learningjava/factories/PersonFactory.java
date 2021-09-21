package com.learningjava.factories;

public class PersonFactory {
    private static int countingID = 0;
    public Person createPerson(String name){
        Person newPerson = new Person(countingID, name);
        countingID++;
        System.out.println(newPerson);
        return newPerson;
    }
}
