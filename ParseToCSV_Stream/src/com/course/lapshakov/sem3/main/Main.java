package com.course.lapshakov.sem3.main;

import com.course.lapshakov.sem3.readerWriterTXT.ReaderWriterTXTtoCSV;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("You should input 2 paths in the program arguments: source is TXT file and destination is CSV file.");
        } else {
            ReaderWriterTXTtoCSV.parseTXTtoCSV(args[0], args[1]);
        }
    }
}
