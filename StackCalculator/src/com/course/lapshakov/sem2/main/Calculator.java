package com.course.lapshakov.sem2.main;

import com.course.lapshakov.sem2.Parsers.ConsoleParser;
import com.course.lapshakov.sem2.Parsers.FileParser;
import com.course.lapshakov.sem2.interfaces.Command;
import com.course.lapshakov.sem2.interfaces.Parser;

import java.util.List;

public class Calculator {
    Parser parser;

    public Calculator(Parser parser) {
        this.parser = parser;
    }

    void execute() {
        List<Command> commands = parser.getCommands();
        for (Command command : commands) {
            command.execute();
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

