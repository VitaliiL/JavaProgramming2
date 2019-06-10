package com.course.lapshakov.sem2.Parsers;

import com.course.lapshakov.sem2.interfaces.*;
import com.course.lapshakov.sem2.operations.*;

import java.util.*;

public class ConsoleParser implements Parser {
    private Stack<Double> stack = new Stack<>();
    private List<Command> userCommand = new ArrayList<>();
    private Map<String, Double> variables = new HashMap<>();
    private String[] arguments;

    private List<Command> listCommand = new ArrayList<>(Arrays.asList(
            new Sum(), new Sub(), new Sqrt(),
            new Div(), new Mult(), new Push(),
            new Pop(), new Print(), new Define()));

    @Override
    public List<Command> getCommands() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("input your commands:");

            while (true) {
                String inputScannerString = scanner.nextLine();

                if (inputScannerString.equalsIgnoreCase("exit")) {
                    break;
                }

                arguments = inputScannerString.split(" ");

                findNeededCommand();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Please check the input command. " + e.getMessage());
        }

        return userCommand;
    }

    private void findNeededCommand() {
        for (Command commandName : listCommand) {
            if (commandName.getCommandName().equalsIgnoreCase(arguments[0])) {

                if (commandName instanceof ArithmeticCommand) {
                    ((ArithmeticCommand) commandName).setStack(stack);
                }

                if (commandName instanceof StackCommand) {
                    ((StackCommand) commandName).setString(arguments);
                }

                if (commandName instanceof DefineCommand) {
                    ((DefineCommand) commandName).setMap(variables);
                }

                commandName = commandName.getCommandObject();
                userCommand.add(commandName);
            }
        }
    }
}
