package com.course.lapshakov.sem2.Parsers;

import com.course.lapshakov.sem2.operations.Command;

import java.io.InputStream;
import java.util.List;

public interface Parser {
    default List<Command> getCommands(InputStream inputStream) {
        return null;
    }

    default List<Command> getUserCommands() {
        return null;
    }
}
