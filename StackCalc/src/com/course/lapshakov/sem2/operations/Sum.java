package com.course.lapshakov.sem2.operations;

import java.util.EmptyStackException;
import java.util.Stack;

public class Sum implements Command {
    private Stack<Double> stack;

    public Sum() {
    }

    private Sum(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public void setStack(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public String getCommandName() {
        return "Sum";
    }

    @Override
    public Sum getCommandObject() {
        return new Sum(stack);
    }

    @Override
    public void executeCommand() throws EmptyStackException {
        stack.push(stack.pop() + stack.pop());
    }
}
