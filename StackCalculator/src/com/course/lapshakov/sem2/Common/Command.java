package com.course.lapshakov.sem2.Common;

import java.util.Map;
import java.util.Stack;

public abstract class Command {
    public abstract String getCommandName();

    public abstract Command getCommandObject();

    public abstract void executeCommand();

    public void setString(String[] arguments) {

    }

    public void setStack(Stack<Double> stack) {

    }

    public void setMap(Map<String, Double> variables) {

    }
}
