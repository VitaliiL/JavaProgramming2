package com.course.lapshakov.sem2.operations;

import com.course.lapshakov.sem2.interfaces.Command;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Define implements Command {
    private String[] arguments;
    private Stack<Double> stack = new Stack<>();

    public Define() {
    }

    private Define(String[] arguments, Stack<Double> stack) {
        this.arguments = arguments;
        this.stack = stack;
    }

    @Override
    public String getCommandName() {
        return "Define";
    }

    @Override
    public Command getCommandObject() {
        return new Define(arguments, stack);
    }


    public void setStack(Stack<Double> stack) {
        this.stack = stack;
    }

    public void setString(String[] arguments) {
        this.arguments = arguments;
    }

    @Override
    public void executeCommand() throws EmptyStackException, NumberFormatException {
        Map<String, Double> variables = new HashMap<>();
        //arguments - [Define, a, 4]

        double variableValue = Double.parseDouble(arguments[2]);
        String variableName = arguments[1];
        variables.put(variableName, variableValue);

        variables.get(variableName);
    }
}
