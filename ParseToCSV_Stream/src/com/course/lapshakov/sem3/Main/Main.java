package com.course.lapshakov.sem3.Main;

import com.course.lapshakov.sem3.ReaderTXT.ReaderTXT;
import com.course.lapshakov.sem3.WriterToCSV.WriterToCSV;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("You should input 2 paths in the program arguments: source is TXT file and destination is CSV file.");
        } else {
            ReaderTXT.parseTXT(args[0]);
            WriterToCSV.writeToCSV(args[1]);
        }
    }
}
