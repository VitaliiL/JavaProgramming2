package com.course.lapshakov.sem2.parsers;

import com.course.lapshakov.sem2.operations.Command;

import java.util.List;

public interface Parser {
    List<Command> getCommands();
}
