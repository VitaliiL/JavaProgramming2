package com.course.lapshakov.sem2.Parsers;

import com.course.lapshakov.sem2.Common.*;
import com.course.lapshakov.sem2.main.UserCommand;

import java.util.*;

public class ConsoleParser implements Parser {
    @Override
    public List<Command> getCommands() {
        List<Command> commandList = new ArrayList<>();
        UserCommand userCommand = new UserCommand();

        Scanner scanner = new Scanner(System.in);
        System.out.println("input your commands:");

        while (true) {
            String inputScannerString = scanner.nextLine();

            if (inputScannerString.equalsIgnoreCase("exit")) {
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
