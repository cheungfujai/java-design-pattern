package com.learningjava.builder;

public class FieldGenerator {
    public String fieldName, dataType;
    public FieldGenerator(String fieldName, String dataType) {
        this.fieldName = fieldName;
        this.dataType = dataType;
    }
    @Override
    public String toString() {
        return String.format("public %s %s;", dataType, fieldName);
    }
}
