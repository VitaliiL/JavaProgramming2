package com.course.lapshakov.sem2.operations;

import com.course.lapshakov.sem2.interfaces.Command;
import com.course.lapshakov.sem2.interfaces.StackCommand;

import java.util.EmptyStackException;
import java.util.Stack;

public class Push implements StackCommand {
    private Stack<Double> stack;
    private String[] arguments;

    public Push() {
    }

    private Push(String[] arguments, Stack<Double> stack) {
        this.stack = stack;
        this.arguments = arguments;
    }

    @Override
    public void setStack(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public void setString(String[] arguments) {
        this.arguments = arguments;
    }

    @Override
    public String getCommandName() {
        return "Push";
    }

    @Override
    public Push getCommandObject() {
        return new Push(arguments, stack);
    }

    @Override
    public void executeCommand() throws EmptyStackException, NumberFormatException {
        stack.push(Double.parseDouble(arguments[1]));
    }
}
