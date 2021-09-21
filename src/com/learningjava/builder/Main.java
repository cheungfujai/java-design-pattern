package com.learningjava.builder;

public class Main {
    public static void main(String[] args){
        CodeBuilder cb = new CodeBuilder("ClassName")
                .addField("name", "String")
                .addField("age", "int")
                .addField("gender", "boolean");
        System.out.println(cb.toString());
    }
}