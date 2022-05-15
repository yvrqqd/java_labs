package com.task2.calculator;

import java.util.Map;
import java.util.Stack;
import java.util.Vector;

public class Container {
    public final Stack<Double> stack;
    private final Map<String, Double> defines;
    public final Vector<String> args;

    public Container(Stack<Double> stack, Map<String, Double> defines, Vector<String> args) {
        this.stack = stack;
        this.defines = defines;
        this.args = args;
    }

    public void push(Double value) {
        stack.push(value);
    }

    public Double pop() {
        return stack.pop();
    }

    public void define(String str, Double value) {
        defines.put(str, value);
    }

    public boolean dataEmpty() {
        return stack.empty();
    }
}