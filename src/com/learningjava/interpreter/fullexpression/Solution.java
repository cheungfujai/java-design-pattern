package com.learningjava.interpreter.fullexpression;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Solution {
    public interface Element{
        int eval();
    }

    public static class MyInteger implements Element{
        private int value;
        public MyInteger(int value){
            this.value = value;
        }
        public int eval() {
            return value;
        }
    }

    public enum ElementType {
        ADD, MINUS, TIMES, DIVIDE
    }

    public static class MyOperation implements Element{

        public ElementType elementType;
        public Element left, right;

        public int eval() {
            switch (elementType){
                case ADD:
                    return left.eval() + right.eval();
                case MINUS:
                    return left.eval() - right.eval();
                case TIMES:
                    return left.eval() * right.eval();
                case DIVIDE:
                    return left.eval() / right.eval();
                default:
                    return 0;
            }
        }
    }

    public static Element parse(List<Token> tokens){
        MyOperation result = new MyOperation();
        boolean haveLeft = false;

        for(int i = 0; i < tokens.size(); ++i){
            Token token = tokens.get(i);
            switch (token.type){
                case INTEGER:
                    MyInteger myInteger = new MyInteger(Integer.parseInt(token.expressionString));
                    if(!haveLeft){
                        result.left = myInteger;
                        haveLeft = true;
                    }
                    else result.right = myInteger;
                    break;
                case PLUS:
                    result.elementType = ElementType.ADD;
                    break;
                case MINUS:
                    result.elementType = ElementType.MINUS;
                    break;
                case TIMES:
                    result.elementType = ElementType.TIMES;
                    break;
                case DIVIDE:
                    result.elementType = ElementType.DIVIDE;
                    break;
                case LB:
                    int j = i;
                    for(; j < tokens.size(); ++j){
                        if(tokens.get(j).type == Type.RB){
                            break;
                        }
                    }
                    List<Token> subString = tokens
                            .stream()
                            .skip(i + 1)
                            .limit(j - i - 1)
                            .collect(Collectors.toList());
                    Element e = parse(subString);
                    if(!haveLeft){
                        result.left = e;
                        haveLeft = true;
                    }
                    else result.right = e;
                    i = j;
                    break;
                default:
                    break;
            }
        }

        return result;
    }

    public enum Type{
        INTEGER, PLUS, MINUS, TIMES, DIVIDE, LB, RB, SPACE
    }

    public static class Token {

        public Type type;
        public String expressionString;

        public Token(Type type, String exxpressionString){
            this.type = type;
            this.expressionString = exxpressionString;
        }

        @Override
        public String toString(){
            return "`" + expressionString + "`";
        }
    }

    public static List<Token> lex(String input){
        ArrayList<Token> result = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            switch (input.charAt(i)){
                case '+':
                    result.add(new Token(Type.PLUS, "+"));
                    break;
                case '-':
                    result.add(new Token(Type.MINUS, "-"));
                    break;
                case '*':
                    result.add(new Token(Type.TIMES, "*"));
                    break;
                case '/':
                    result.add(new Token(Type.DIVIDE, "/"));
                    break;
                case '(':
                    result.add(new Token(Type.LB, "("));
                    break;
                case ')':
                    result.add(new Token(Type.RB, ")"));
                    break;
                case ' ':
                    break;
                default:
                    StringBuilder sb = new StringBuilder("" + input.charAt(i));
                    for(int j = i + 1; j < input.length(); j++){
                        if(Character.isDigit(input.charAt(j))){
                            sb.append(input.charAt(j));
                            i++;
                        }
                        else{
                            result.add(new Token(
                                    Type.INTEGER,
                                    sb.toString()
                            ));
                            break;
                        }
                    }
                    break;
            }
        }

        return result;
    }

    public static int calculate(String s) {
        List<Token> tokens = lex(s);
        Element parsedElement = parse(tokens);
        return parsedElement.eval();
    }

    public static void main(String[] args){
        int ans = calculate("1 + 1");
        System.out.println(ans);
    }
}