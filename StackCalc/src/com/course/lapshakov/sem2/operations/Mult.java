package com.course.lapshakov.sem2.operations;

import java.util.EmptyStackException;
import java.util.Stack;

public class Mult implements Command {
    private Stack<Double> stack;

    public Mult() {
    }

    private Mult(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public void setStack(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public String getCommandName() {
        return "Mult";
    }

    @Override
    public Command getCommandObject() {
        return new Mult(stack);
    }

    @Override
    public void executeCommand() throws EmptyStackException {
        stack.push(stack.pop() * stack.pop());
    }
}
