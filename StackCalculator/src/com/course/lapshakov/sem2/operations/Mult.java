package com.course.lapshakov.sem2.operations;

import com.course.lapshakov.sem2.interfaces.ArithmeticCommand;
import com.course.lapshakov.sem2.interfaces.Command;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;

public class Mult implements ArithmeticCommand {
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
