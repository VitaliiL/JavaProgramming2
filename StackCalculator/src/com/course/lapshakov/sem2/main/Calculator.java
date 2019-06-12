package com.course.lapshakov.sem2.main;

import com.course.lapshakov.sem2.Parsers.ConsoleParser;
import com.course.lapshakov.sem2.Parsers.FileParser;
import com.course.lapshakov.sem2.Common.Command;
import com.course.lapshakov.sem2.Common.Parser;

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
            parser = new FileParser(args[0], args[1]);
        }

        Calculator calc = new Calculator(parser);
        calc.execute();
    }
}

