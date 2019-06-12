package com.course.lapshakov.sem2.main;

import com.course.lapshakov.sem2.Common.Command;
import com.course.lapshakov.sem2.operations.*;

import java.util.*;

/*
* This class forms a user command list.
*
* @para COMMAND_LIST is common list with all possible command.
* @return user command list.
*
* */

public class UserCommand {
    private Stack<Double> stack = new Stack<>();
    private Map<String, Double> variables = new HashMap<>();
    private static final List<Command> COMMAND_LIST = new ArrayList<>(Arrays.asList(
            new Sum(), new Sub(), new Sqrt(),
            new Div(), new Mult(), new Push(),
            new Pop(), new Print(), new Define()));

    public Command findNeededCommand(String[] arguments) {
        for (Command commandName : COMMAND_LIST) {
            if (commandName.getCommandName().equalsIgnoreCase(arguments[0])) {
                commandName.setStack(stack);
                commandName.setString(arguments);
                commandName.setMap(variables);

                return commandName.getCommandObject();
            }
        }

        throw new IllegalArgumentException("Command format isn't correct. Check the input command.");
    }
}
