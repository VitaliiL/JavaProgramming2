package com.course.lapshakov.sem2.parsers;

import com.course.lapshakov.sem2.main.UserCommand;
import com.course.lapshakov.sem2.operations.Command;

import java.util.*;

public class ConsoleParser implements Parser {
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public List<Command> getCommands() {
        List<Command> commandList = new ArrayList<>();
        UserCommand userCommand = new UserCommand();

        System.out.println("input your commands:");

        while (true) {
            String inputScannerString = SCANNER.nextLine();

            if ("exit".equalsIgnoreCase(inputScannerString)) {
                break;
            } else {
                if (inputScannerString.isEmpty()) {
                    continue;
                }
            }

            var arguments = inputScannerString.split(" ");

            Command command = userCommand.findNeededCommand(arguments);

            if (command != null) {
                commandList.add(command);
            }
        }

        return commandList;
    }
}
