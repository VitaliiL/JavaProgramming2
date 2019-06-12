package com.course.lapshakov.sem2.operations;

import com.course.lapshakov.sem2.Common.Command;

import java.util.EmptyStackException;
import java.util.Stack;

public class Pop extends Command {
    private Stack<Double> stack;

    public Pop() {
    }

    private Pop(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public void setStack(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public String getCommandName() {
        return "Pop";
    }

    @Override
    public Command getCommandObject() {
        return new Pop(stack);
    }

    @Override
    public void executeCommand() throws EmptyStackException {
        stack.pop();
    }
}
