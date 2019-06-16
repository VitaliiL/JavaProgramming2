package com.course.lapshakov.sem2.parsers;

import com.course.lapshakov.sem2.operations.Command;

import java.util.*;

public class ConsoleParser implements Parser {
    private static Reader reader = new Reader();

    @Override
    public List<Command> getUserCommands() throws IllegalArgumentException{
        return reader.getCommands(System.in);
    }
}
