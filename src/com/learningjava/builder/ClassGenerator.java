package com.learningjava.builder;

import java.util.ArrayList;
import java.util.List;

public class ClassGenerator {
    public String className;
    public List<FieldGenerator> fields = new ArrayList<>();
    public ClassGenerator(){}
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String nl = System.lineSeparator();
        sb.append("public class " + className).append(" {").append(nl);
        for (FieldGenerator field : fields) sb.append("  " +  field).append(nl);
        sb.append("}").append(nl);
        return sb.toString();
    }
}