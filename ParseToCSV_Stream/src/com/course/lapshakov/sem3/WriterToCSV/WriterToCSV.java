package com.course.lapshakov.sem3.WriterToCSV;

import com.course.lapshakov.sem3.ReaderTXT.ReaderTXT;
import com.course.lapshakov.sem3.WordCounter.WordCounter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterToCSV {
    private static final char SEPARATOR = ';';
    private static Map<String, WordCounter> statMap = ReaderTXT.getStatMap();


    public static void writeToCSV(String fileCSV) {
        int maxWords = ReaderTXT.getWordsTotalAmount();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileCSV))) {



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
