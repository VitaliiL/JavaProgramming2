package com.course.lapshakov.sem2.Parsers;

import com.course.lapshakov.sem2.common.Command;
import com.course.lapshakov.sem2.main.UserCommand;
import com.course.lapshakov.sem2.operations.Print;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileParser implements Parser {
    private List<Command> commandList = new ArrayList<>();

    @SuppressWarnings("InfiniteLoopStatement")
    public FileParser(String inputFile, String outputFile) {
        UserCommand userCommand = new UserCommand();

        try (Scanner scanner = new Scanner(new FileInputStream(inputFile));
             PrintWriter writer = new PrintWriter(outputFile)) {

            while (true) {
                String inputScannerString = scanner.nextLine();

                if("print".equalsIgnoreCase(scanner.nextLine()))
                    throw new IllegalArgumentException("You should to finish command input by \"print\"");

                var arguments = inputScannerString.split(" ");

                Command command = userCommand.findNeededCommand(arguments);

                if (command != null) {
                    commandList.add(command);
                }

                if ("print".equalsIgnoreCase(inputScannerString)) {
                    writer.println("Result: " + new Print().getResult());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Your file not found.");
            e.printStackTrace();
        } catch (NoSuchElementException e){
            System.err.println("File is empty.");
        }
    }

    @Override
    public List<Command> getCommands() {
        return commandList;
    }
}
