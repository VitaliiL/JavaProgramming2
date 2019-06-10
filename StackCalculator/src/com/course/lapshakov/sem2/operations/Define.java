package com.course.lapshakov.sem2.operations;

import com.course.lapshakov.sem2.interfaces.Command;
import com.course.lapshakov.sem2.interfaces.DefineCommand;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Define implements DefineCommand {
    private String[] arguments;
    private Map<String, Double> variables = new HashMap<>();

    public Define() {
    }

    private Define(String[] arguments, Map<String, Double> variables) {
        this.arguments = arguments;
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
    public void setMap(Map<String, Double> variables) {
        this.variables = variables;
    }

    public void setString(String[] arguments) {
        this.arguments = arguments;
    }

    @Override
    public void executeCommand() throws EmptyStackException, NumberFormatException {
        //arguments - [Define, a, 4]

        double variableValue = Double.parseDouble(arguments[2]);
        String variableName = arguments[1];
        variables.put(variableName, variableValue);

        variables.get(variableName);
    }
}
