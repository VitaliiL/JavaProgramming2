package com.course.lapshakov.sem3.readerWriterTXT;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderWriterTXTtoCSV {
    private static final String WORD_SEPARATOR = " ";

    public static void parseTXTtoCSV(String fileTXT, String fileCSV) {
//        String path1 = Main.class
//                .getClassLoader()
//                .getResource("in.txt")
//                .toURI()
//                .getPath();

        Path path = Paths.get(fileTXT);
        AtomicLong atomicLong = new AtomicLong(0);

        try (Stream<String> lines = Files.lines(path);
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileCSV)) {
             }) {
            Map<String, Long> map =
                    lines
                            .flatMap((String line) -> {
                                String[] words = line.split(WORD_SEPARATOR);
                                return Arrays.stream(words);
                            })
                            .peek(counter -> atomicLong.incrementAndGet()  )
                            .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

            map.entrySet()
                    .stream()
                    .sorted(Comparator
                            .comparingLong(Map.Entry<String, Long>::getValue)
                            .reversed()
                            .thenComparing(Map.Entry::getKey))
                    .forEach(entry -> {
                        try {
                            bufferedWriter.write(fileCSV);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

