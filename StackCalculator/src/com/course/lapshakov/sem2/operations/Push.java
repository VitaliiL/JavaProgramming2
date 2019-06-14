package com.course.lapshakov.sem2.operations;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;

public class Push implements Command {
    private Stack<Double> stack;
    private String[] arguments;
    private Map<String, Double> variables;

    public Push() {
    }

    private Push(String[] arguments, Stack<Double> stack, Map<String, Double> variables) {
        this.stack = stack;
        this.arguments = arguments;
        this.variables = variables;
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
    public void setMap(Map<String, Double> variables) {
        this.variables = variables;
    }

    @Override
    public String getCommandName() {
        return "Push";
    }

    @Override
    public Push getCommandObject() {
        return new Push(arguments, stack, variables);
    }

    @Override
    public void executeCommand() throws EmptyStackException, IllegalArgumentException {
        if (isNumber(arguments[1])) {
            stack.push(Double.parseDouble(arguments[1]));
        } else {
            if (variables.isEmpty()) {
                throw new IllegalArgumentException("You should input an argument for \"define\" command.");
            } else {
                stack.push(variables.get(arguments[1]));
            }

        }
    }

    /*
    * Check arguments of push command.
    * If arguments[1] isn't digit arguments are after define command.
    * */

    private boolean isNumber(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("You should input an argument for \"push\" command.");
        }

        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
