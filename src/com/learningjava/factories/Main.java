package com.learningjava.factories;

/**
 *
 You are given a class called Person.
 The person has two fields: id and name.

 Please implement a non-static PersonFactory that has a createPerson() method
 that takes a person's name and returns a new instance of Person.

 The id of the person returned should be set as a 0-based index of the object created by that factory.
 So, the first person the factory makes should have id=0, second id=1 and so on.
 *
 **/
public class Main {
    public static void main(String[] args){
        PersonFactory factory = new PersonFactory();
        factory.createPerson("Gavin");
        factory.createPerson("Kevin");
        factory.createPerson("Calvin");
    }
}
