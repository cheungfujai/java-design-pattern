package com.learningjava.builder;

public class CodeBuilder {
    private ClassGenerator classGenerator = new ClassGenerator();
    public CodeBuilder(String rootName) {
        classGenerator.className = rootName;
    }
    public CodeBuilder addField(String name, String type) {
        classGenerator.fields.add(new FieldGenerator(name, type));
        return this;
    }
    @Override
    public String toString() {
        return classGenerator.toString();
    }
}