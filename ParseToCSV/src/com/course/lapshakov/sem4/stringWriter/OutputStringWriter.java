package com.course.lapshakov.sem4.stringWriter;

import com.course.lapshakov.sem4.wordCounter.WordCounter;
import com.course.lapshakov.sem4.stringReader.InputStringReader;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputStringWriter implements StringWriter {
    private static final char SEPARATOR = ';';
    private Map<String, WordCounter> statMap = InputStringReader.getStatMap();
    private List<WordCounter> wordCountersList = new ArrayList<>();

    @Override
    public void writeString(String outputString) {
        int maxWords = InputStringReader.getWordsTotalAmount();

        wordCountersList = getSortList();
        try (PrintWriter printWriter = new PrintWriter(outputString)) {
            for (WordCounter element : wordCountersList) {
                printWriter.write(element.toString());
                printWriter.write(SEPARATOR);

                double counter = element.getCounter();

                double wordFrequency = counter / maxWords * 100;
                printWriter.write(String.format("%.2f%n", wordFrequency));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<WordCounter> getSortList() {
        for (String word : statMap.keySet()) {
            wordCountersList.add(statMap.get(word));
        }

        Collections.sort(wordCountersList);

        return wordCountersList;
    }
}
