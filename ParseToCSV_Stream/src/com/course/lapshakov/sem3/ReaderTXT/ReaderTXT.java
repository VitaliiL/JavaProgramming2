package com.course.lapshakov.sem3.ReaderTXT;

import com.course.lapshakov.sem3.WordCounter.WordCounter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ReaderTXT {
    private static final String WORD_SEPARATOR = " ";
    private static Map<String, WordCounter> statMap = new HashMap<>();
    private static int wordsTotalAmount = 0;

    public static void parseTXT(String fileTXT) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileTXT))){
            if (bufferedReader.read() == 0) {
                System.err.println("File is empty");
            }

            while (bufferedReader.readLine() != null) {
                String inputString = bufferedReader.readLine();
                String [] wordArray = inputString.split(WORD_SEPARATOR);

                for(int i = 0; i < wordArray.length; i++){
                    if (statMap.containsKey(String.valueOf(i))) {
                        WordCounter wordCounter1 = statMap.get(String.valueOf(i));

                        int counter = wordCounter1.getCounter();
                        counter++;

                        wordCounter1.setCounter(counter);
                    } else {
                        WordCounter wordCounter = new WordCounter(String.valueOf(i), 1);
                        statMap.put(String.valueOf(i), wordCounter);
                    }

                     wordsTotalAmount = i;
                }
            }
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
