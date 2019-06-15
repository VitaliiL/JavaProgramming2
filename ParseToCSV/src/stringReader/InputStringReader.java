package stringReader;

import comporator.WordCounter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class InputStringReader implements Reader {
    private static final char SPACE = ' ';
    private static Map<String, WordCounter> statMap = new HashMap<>();
    private static int wordsTotalAmount = 0;

    @Override
    public void readString(String inputString) {
        StringBuilder stringBuilder = new StringBuilder();

        try (Scanner scanner = new Scanner(new FileInputStream(inputString))) {
            if (!scanner.hasNextLine()) {
                System.err.println("File is empty");
            }

            while (scanner.hasNextLine()) {
                String inputScanner = scanner.nextLine();

                for (int i = 0; i < inputScanner.length(); i++) {
                    char symbol = inputScanner.charAt(i);

                    if (Character.isLetterOrDigit(symbol)) {
                        stringBuilder.append(symbol);
                    }

                    if (symbol == SPACE || i == inputScanner.length() - 1) {
                        if (statMap.containsKey(stringBuilder.toString())) {
                            WordCounter wordCounter1 = statMap.get(stringBuilder.toString());

                            int counter = wordCounter1.getCounter();
                            counter++;

                            wordCounter1.setCounter(counter);
                        } else {
                            WordCounter wordCounter = new WordCounter(stringBuilder.toString(), 1);

                            statMap.put(stringBuilder.toString(), wordCounter);
                        }
                        stringBuilder.setLength(0);
                        wordsTotalAmount++;
                    }
                }
            }
        } catch (
                FileNotFoundException e) {
            System.err.println("File not found.");
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