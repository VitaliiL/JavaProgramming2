package com.course.lapshakov.sem2.interfaces;

import java.util.Stack;

public interface Command {
    String getCommandName();

    Command getCommandObject();

    void executeCommand();
}
