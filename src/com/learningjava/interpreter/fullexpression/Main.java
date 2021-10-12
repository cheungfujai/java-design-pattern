package com.learningjava.interpreter.fullexpression;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public interface Element{
        int eval();
    }

    public static class MyInteger implements Element{
        private int value;
        public MyInteger(int value){
            this.value = value;
        }
        @Override
        public int eval() {
            return value;
        }
    }

    public static class MyOperation implements Element{
        public enum ElementType {
            ADD,
            MINUS,
            TIMES,
            DIVIDE
        }

        public ElementType elementType;
        public Element left, right;

        @Override
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

    public static class Token {
        public enum Type{
            INTEGER, PLUS, MINUS, TIMES, DIVIDE, LB, RB, SPACE
        }

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
                    result.elementType = MyOperation.ElementType.ADD;
                    break;
                case MINUS:
                    result.elementType = MyOperation.ElementType.MINUS;
                    break;
                case TIMES:
                    result.elementType = MyOperation.ElementType.TIMES;
                    break;
                case DIVIDE:
                    result.elementType = MyOperation.ElementType.DIVIDE;
                    break;
                case LB:
                    int j = i;
                    for(; j < tokens.size(); ++j){
                        if(tokens.get(j).type == Token.Type.RB){
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

    public static List<Token> lex(String input){
        ArrayList<Token> result = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            switch (input.charAt(i)){
                case '+':
                    result.add(new Token(Token.Type.PLUS, "+"));
                    break;
                case '-':
                    result.add(new Token(Token.Type.MINUS, "-"));
                    break;
                case '*':
                    result.add(new Token(Token.Type.TIMES, "*"));
                    break;
                case '/':
                    result.add(new Token(Token.Type.DIVIDE, "/"));
                    break;
                case '(':
                    result.add(new Token(Token.Type.LB, "("));
                    break;
                case ')':
                    result.add(new Token(Token.Type.RB, ")"));
                    break;
                case ' ':
                    //result.add(new Token(Token.Type.SPACE, ""));
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
                                    Token.Type.INTEGER,
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

    public static void main(String[] args){
        String input = "(13 + 4) - (12 + 1)";
        List<Token> tokens = lex(input);
        Element parsedElement = parse(tokens);
        System.out.println(parsedElement.eval());
    }
}
