package com.course.lapshakov.sem4.stringWriter;

import com.course.lapshakov.sem4.wordCounter.WordCounter;
import com.course.lapshakov.sem4.stringReader.InputStringReader;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class OutputStringWriter {
    private static final char SEPARATOR = ';';
    private Map<String, WordCounter> statMap = InputStringReader.getStatMap();
    private List<WordCounter> wordCountersList = new ArrayList<>();

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
        wordCountersList.addAll(statMap.values());

//        for (String word : statMap.keySet()) {
//            wordCountersList.add(statMap.get(word));
//        }

//        need to replace with lambda or reference:
        wordCountersList.sort(new Comparator<>() {
            @Override
            public int compare(WordCounter o1, WordCounter o2) {
                return o1.compareTo(o2);
            }
        });

/*        other variants to sort:
        Set<WordCounter> wordCountersSet = new TreeSet<>(wordCountersList);

        Collections.sort(wordCountersList);

        wordCountersList.sort(
                Comparator
                .comparingLong(WordCounter::getCounter)
                .reversed()
                .thenComparing(WordCounter::getWord)
        );*/

        return wordCountersList;
    }
}
