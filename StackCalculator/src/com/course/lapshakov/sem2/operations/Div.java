package com.course.lapshakov.sem2.operations;

import com.course.lapshakov.sem2.interfaces.Command;

import java.util.EmptyStackException;
import java.util.Stack;

public class Div implements Command {
    private Stack<Double> stack;

    public Div() {
    }

    private Div(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public void setStack(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public String getCommandName() {
        return "Div";
    }

    @Override
    public Command getCommandObject() {
        return new Div(stack);
    }

    @Override
    public void executeCommand() throws EmptyStackException {
        double denominator = stack.pop();
        double numerator = stack.pop();

        if (denominator == 0) {
            throw new IllegalArgumentException("Check inputted data. The denominator can't be zero.");
        }

        stack.push(numerator / denominator);
    }
}
