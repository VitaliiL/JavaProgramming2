package com.course.lapshakov.sem2.Parsers;

import com.course.lapshakov.sem2.operations.Command;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class FileParser implements Parser {
    private String inputFile;
    private static InputStringReader reader = new InputStringReader();

    public FileParser(String inputFile) {
        this.inputFile = inputFile;
    }

    @Override
    public List<Command> getUserCommands() throws IllegalArgumentException {
        try {
            return reader.getCommands(new FileInputStream(inputFile));
        } catch (FileNotFoundException e) {
            System.err.println("Your file not found.");
            e.printStackTrace();
        }

        throw new IllegalArgumentException("There are no commands.");
    }
    
}