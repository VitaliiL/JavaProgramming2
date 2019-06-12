package com.course.lapshakov.sem2.operations;

import com.course.lapshakov.sem2.Common.Command;

import java.util.EmptyStackException;
import java.util.Stack;

public class Sum extends Command {
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
