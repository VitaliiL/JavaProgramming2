package com.course.lapshakov.sem2.operations;

import com.course.lapshakov.sem2.Common.Command;

import java.util.EmptyStackException;
import java.util.Map;

public class Define extends Command {
    private static final int DEFINE_SIZE = 3;
    private String[] arguments;
    private Map<String, Double> variables;

    public Define() {
    }

    private Define(String[] arguments, Map<String, Double> variables) {
        this.arguments = arguments;
        this.variables = variables;
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
        return "Define";
    }

    @Override
    public Command getCommandObject() {
        return new Define(arguments, variables);
    }

    @Override
    public void executeCommand() throws EmptyStackException, NumberFormatException, ArrayIndexOutOfBoundsException {
        //arguments - [Define, a, 4]
        if (arguments.length != DEFINE_SIZE) {
            throw new IllegalArgumentException("You should input an argument for \"define\" command.");
        }

        double variableValue = Double.parseDouble(arguments[2]);
        String variableName = arguments[1];
        variables.put(variableName, variableValue);
    }
}
