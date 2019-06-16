package com.course.lapshakov.sem4.stringReader;

import com.course.lapshakov.sem4.wordCounter.WordCounter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class InputStringReader implements StringReader {
    private static final char SPACE = ' ';
    private static Map<String, WordCounter> statMap = new HashMap<>();
    private static int wordsTotalAmount = 0;

    @Override
    public void readString(String inputString) {
        StringBuilder stringBuilder = new StringBuilder();

        try (Reader reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(inputString)), StandardCharsets.UTF_8)) {
            if (reader.read() == 0) {
                System.err.println("File is empty");
            }

            int inputData = 0;

            while (reader.ready()) {
                char symbol = (char) inputData;
                inputData = reader.read();

                if (Character.isLetterOrDigit(symbol)) {
                    stringBuilder.append(symbol);
                }

                if (symbol == SPACE) {
                    String inputBuilderString = stringBuilder.toString().toLowerCase();
                    if (statMap.containsKey(inputBuilderString)) {
                        WordCounter wordCounter1 = statMap.get(inputBuilderString);

                        int counter = wordCounter1.getCounter();
                        counter++;

                        wordCounter1.setCounter(counter);
                    } else {
                        WordCounter wordCounter = new WordCounter(inputBuilderString, 1);
                        statMap.put(inputBuilderString, wordCounter);
                    }

                    stringBuilder.setLength(0);
                    wordsTotalAmount++;
                }
            }

        } catch (
                FileNotFoundException e) {
            System.err.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, WordCounter> getStatMap() {
        return statMap;
    }

    public static int getWordsTotalAmount() {
        return wordsTotalAmount;
    }
}
//String.format("%.2f%n", wordFrequency)   statMap.merge(wordCounter, counter, Integer::sum);