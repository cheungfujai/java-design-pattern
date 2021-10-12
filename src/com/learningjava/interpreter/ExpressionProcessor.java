package com.learningjava.interpreter;

import java.util.HashMap;
import java.util.Map;

public class ExpressionProcessor {
    public Map<Character, Integer> variables = new HashMap<>();

    public enum Operation{
        NOTHING, ADD, MINUS
    }

    public static Integer parseString(String text) {
        try {
            return Integer.parseInt(text);
        }
        catch (NumberFormatException e){
            return null;
        }
    }

    public int calculate(String expression) {
        int result = 0;
        Operation ops = Operation.NOTHING;

        String[] res = expression.split("(?<=[+-])");

        for(String s : res){
            String[] noOp = s.split("[+-]");
            String first = noOp[0];
            int val;

            Integer v = parseString(first);
            if (v != null) val = v.intValue();
            else if (first.length() == 1 && variables.containsKey(first.charAt(0))) val = variables.get(first.charAt(0));
            else return 0;

            switch (ops) {
                case NOTHING:
                    result = val;
                    break;
                case ADD:
                    result += val;
                    break;
                case MINUS:
                    result -= val;
                    break;
            }

            if (s.endsWith("+")) ops = ops.ADD;
            else if (s.endsWith("-")) ops = ops.MINUS;
        }

        return result;
    }
}
