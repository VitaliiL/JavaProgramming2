package com.course.lapshakov.sem4.stringReader;

import com.course.lapshakov.sem4.wordCounter.WordCounter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class InputStringReader {
    private static final char SPACE = ' ';
    private static int wordsTotalAmount = 0;
    private static final int DEFAULT_COUNTER_VALUE = 1;
    private static final int STRING_BUILDER_SET_LENGTH = 0;
    private static Map<String, WordCounter> statMap = new HashMap<>();
    private StringBuilder stringBuilder = new StringBuilder();

    public void readString(String inputString) {
        try (Reader reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(inputString)), StandardCharsets.UTF_8)) {
            int inputData;

            while ((inputData = reader.read()) != -1) {
                char symbol = (char) inputData;

                if (Character.isLetterOrDigit(symbol)) {
                    stringBuilder.append(symbol);
                }

                if (symbol == SPACE || symbol == '\n') {
                    checkWordAndAddToMap(stringBuilder);
                }
            }

            if ((stringBuilder.length()) != 0) {
                checkWordAndAddToMap(stringBuilder);
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

    private void checkWordAndAddToMap(StringBuilder inputWord) {
        int counter;
        String word = inputWord.toString().toLowerCase();

        if (statMap.containsKey(word)) {
            WordCounter existWordCounter = statMap.get(word);

            counter = existWordCounter.getCounter();
            counter++;

            existWordCounter.setCounter(counter);
        } else {
            WordCounter newWordCounter = new WordCounter(word, DEFAULT_COUNTER_VALUE);
            statMap.put(word, newWordCounter);
        }

        stringBuilder.setLength(STRING_BUILDER_SET_LENGTH);
        wordsTotalAmount++;
    }
}