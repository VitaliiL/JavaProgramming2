package com.course.lapshakov.sem4.operations;


public class ParserTXT {
    public static void main(String[] args) {
        InputStr inputStringReader = new InputStringReader();
        OutputStringWriter outputStringWriter = new OutputStringWriter();

        if (args.length != 2) {
            System.err.println("You should input 2 paths in the program arguments: source is TXT file and destination is CSV file.");
        } else {
            inputStringReader.readString(args[0]);
            outputStringWriter.writeString(args[1]);
        }
    }
}
