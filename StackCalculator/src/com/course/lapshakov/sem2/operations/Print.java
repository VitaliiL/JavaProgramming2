package com.course.lapshakov.sem2.operations;

import com.course.lapshakov.sem2.interfaces.ArithmeticCommand;
import com.course.lapshakov.sem2.interfaces.Command;

import java.util.EmptyStackException;
import java.util.Stack;

public class Print implements ArithmeticCommand {
    private Stack<Double> stack;

    public Print() {
    }

    private Print(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public void setStack(Stack<Double> stack) {
        this.stack = stack;
    }

    @Override
    public String getCommandName() {
        return "Print";
    }

    @Override
    public Print getCommandObject() {
        return new Print(stack);
    }

    @Override
    public void executeCommand() throws EmptyStackException {
        System.out.println("Result: " + stack.peek());
    }
}
