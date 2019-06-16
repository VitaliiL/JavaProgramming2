package com.course.lapshakov.sem2.parsers;

import com.course.lapshakov.sem2.operations.Command;
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
    private String inputFile;
    private String outputFile;

    public FileParser(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @SuppressWarnings("InfiniteLoopStatement")
    @Override
    public List<Command> getCommands() {
        List<Command> commandList = new ArrayList<>();
        UserCommand userCommand = new UserCommand();

        try (Scanner scanner = new Scanner(new FileInputStream(inputFile));
             PrintWriter writer = new PrintWriter(outputFile)) {

            while (scanner.hasNextLine()) {
                String inputScannerString = scanner.nextLine();

                var arguments = inputScannerString.split(" ");

                Command command = userCommand.findNeededCommand(arguments);

                if (command != null) {
                    commandList.add(command);
                }

                if ("print".equalsIgnoreCase(inputScannerString)) {
                    //writer.write();
                  break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Your file not found.");
            e.printStackTrace();
        }

        return commandList;
    }
}
