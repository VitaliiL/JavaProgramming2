package com.course.lapshakov.sem2.main;

import com.course.lapshakov.sem2.Parsers.ConsoleParser;
import com.course.lapshakov.sem2.Parsers.FileParser;
import com.course.lapshakov.sem2.Parsers.Parser;
import com.course.lapshakov.sem2.operations.Print;
import com.course.lapshakov.sem2.operations.Command;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.EmptyStackException;
import java.util.List;

public class Calculator {
    private Parser parser;
    private String outputFile;

    private Calculator(Parser parser) {
        this.parser = parser;
    }

    private Calculator(Parser parser, String outputFile) {
        this.parser = parser;
        this.outputFile = outputFile;
    }

    private void execute() {
        List<Command> commands = parser.getUserCommands();

        try {
            for (Command command : commands) {
                command.executeCommand();

                if (parser instanceof ConsoleParser && command instanceof Print) {
                    ((Print) command).printToConsole();
                }

                if (parser instanceof FileParser && command instanceof Print) {
                    PrintWriter printWriter = new PrintWriter(outputFile);
                    double res = ((Print) command).printToFile();
                    printWriter.write("Result: " + res);
                    printWriter.close();
                }
            }
        } catch (EmptyStackException e) {
            System.err.println("Your stack is empty. Need to push values.");
        } catch (NumberFormatException e) {
            System.err.println("Check your argument format.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Check your arguments.");
        } catch (FileNotFoundException e) {
            System.err.println("Your file not found.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Parser parser;

        if (args.length == 0) {
            parser = new ConsoleParser();
            Calculator calcConsole = new Calculator(parser);
            calcConsole.execute();
        } else {
            if (args.length != 2) {
                System.err.println("You should input 2 paths in the program arguments: source and destination files.");
            }

            parser = new FileParser(args[0]);
            Calculator calcFile = new Calculator(parser, args[1]);
            calcFile.execute();
        }
    }
}

