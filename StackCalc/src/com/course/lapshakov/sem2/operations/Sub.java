package com.course.lapshakov.sem2.operations;

import java.util.EmptyStackException;
import java.util.Stack;

public class Sub implements Command  {
    private Stack<Double> stack;

    public Sub() {
    }

    private Sub(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public void setStack(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public String getCommandName() {
        return "Sub";
    }

    @Override
    public Command getCommandObject() {
        return new Sub(stack);
    }

    @Override
    public void executeCommand() throws EmptyStackException {
        double secondValue = stack.pop();
        double firstValue = stack.pop();

        stack.push(firstValue - secondValue);
    }
}
