package com.course.lapshakov.sem2.operations;


import com.course.lapshakov.sem2.interfaces.ArithmeticCommand;
import com.course.lapshakov.sem2.interfaces.Command;

import java.util.EmptyStackException;
import java.util.Stack;

public class Sub implements ArithmeticCommand {
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
