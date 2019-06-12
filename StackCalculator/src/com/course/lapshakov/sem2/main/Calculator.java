package com.course.lapshakov.sem2.main;

import com.course.lapshakov.sem2.parsers.ConsoleParser;
import com.course.lapshakov.sem2.parsers.FileParser;
import com.course.lapshakov.sem2.operations.Command;
import com.course.lapshakov.sem2.parsers.Parser;

import java.util.EmptyStackException;
import java.util.List;

public class Calculator {
    private Parser parser;

    private Calculator(Parser parser) {
        this.parser = parser;
    }

    private void execute() {
        List<Command> commands = parser.getCommands();

        try {
            for (Command command : commands) {
                command.executeCommand();
            }
        } catch (EmptyStackException e) {
            System.err.println("Your stack is empty. Need to push values.");
        } catch (NumberFormatException e) {
            System.err.println("Check your argument format.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Parser parser;

        if (args.length == 0) {
            parser = new ConsoleParser();
        } else {
            if (args.length != 2) {
                System.err.println("You should input 2 paths in the program arguments: source and destination files.");
            }

            parser = new FileParser(args[0], args[1]);
        }

        Calculator calc = new Calculator(parser);
        calc.execute();
    }
}

