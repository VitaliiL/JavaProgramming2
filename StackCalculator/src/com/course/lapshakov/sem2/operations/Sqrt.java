package com.course.lapshakov.sem2.operations;

import com.course.lapshakov.sem2.interfaces.Command;

import java.util.EmptyStackException;
import java.util.Stack;

public class Sqrt implements Command {
    private Stack<Double> stack;

    public Sqrt() {
    }

    private Sqrt(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public void setStack(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public String getCommandName() {
        return "Sqrt";
    }

    @Override
    public Command getCommandObject() {
        return new Sqrt(stack);
    }

    @Override
    public void executeCommand() throws EmptyStackException {
        stack.push(Math.sqrt(stack.pop()));
    }
}
