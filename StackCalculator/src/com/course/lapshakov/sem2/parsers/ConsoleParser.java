package com.course.lapshakov.sem2.Parsers;

import com.course.lapshakov.sem2.operations.Command;

import java.util.*;

public class ConsoleParser implements Parser {
    private static InputStringReader reader = new InputStringReader();

    @Override
    public List<Command> getUserCommands() throws IllegalArgumentException{
        return reader.getCommands(System.in);
    }
}
