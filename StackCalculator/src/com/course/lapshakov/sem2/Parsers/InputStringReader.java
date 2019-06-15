package com.course.lapshakov.sem2.Parsers;

import com.course.lapshakov.sem2.main.CommandFactory;
import com.course.lapshakov.sem2.operations.Command;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputStringReader implements Parser {
    private static List<Command> commandList = new ArrayList<>();
    private static InputStringReader reader = new InputStringReader();

    @Override
    public List<Command> getCommands(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        CommandFactory commandFactory = new CommandFactory();

        if (inputStream.equals(System.in)) {
            System.out.println("input your commands:");
        }

        while (scanner.hasNextLine()) {
            String inputScannerString = scanner.nextLine();

            if ("exit".equalsIgnoreCase(inputScannerString)) {
                break;
            } else {
                if (inputScannerString.isEmpty()) {
                    continue;
                }
            }

            var arguments = inputScannerString.split(" ");

            Command command = commandFactory.findNeededCommand(arguments);

            if (command != null) {
                commandList.add(command);
            }
        }

        return commandList;
    }
}
