package com.course.lapshakov.sem2.operations;

import java.util.Map;
import java.util.Stack;

public interface Command {
    String getCommandName();

    Command getCommandObject();

    void executeCommand();

    default void setString(String[] arguments) {

    }

    default void setStack(Stack<Double> stack) {

    }

    default void setMap(Map<String, Double> variables) {

    }
}
