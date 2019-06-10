package com.course.lapshakov.sem2.Parsers;

import com.course.lapshakov.sem2.interfaces.Command;
import com.course.lapshakov.sem2.interfaces.Parser;
import com.course.lapshakov.sem2.interfaces.StackCommand;
import com.course.lapshakov.sem2.operations.*;

import java.util.*;

public class ConsoleParser implements Parser {
    private List<Command> listCommand = new ArrayList<>(Arrays.asList(
            new Sum(), new Sub(), new Sqrt(),
            new Div(), new Mult(), new Push(),
            new Pop(), new Print(), new Define()));

    @Override
    public List<Command> getCommands() {
        Stack<Double> stack = new Stack<>();
        List<Command> userCommand = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("input your commands:");

            while (true) {
                String inputScannerString = scanner.nextLine();

                if (inputScannerString.equalsIgnoreCase("exit")) {
                    break;
                }

                String[] arguments = inputScannerString.split(" ");


                for (Command commandName : listCommand) {
                    if (commandName.getCommandName().equalsIgnoreCase(arguments[0])) {
                        commandName.setStack(stack);

                        if (commandName instanceof StackCommand) {
                            ((StackCommand) commandName).setString(arguments);
                        }

                        commandName = commandName.getCommandObject();
                        userCommand.add(commandName);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Please check the input command. " + e.getMessage());
        }

        return userCommand;
    }
}

