package com.learningjava.visit;

public abstract class Expression {
    abstract void accept(ExpressionVisitor ev);
}
