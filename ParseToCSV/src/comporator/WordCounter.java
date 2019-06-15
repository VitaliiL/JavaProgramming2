package comporator;

import java.util.Objects;

public class WordCounter implements Comparable<WordCounter> {
    private String word;
    private int counter;

    public WordCounter(String word, int counter) {
        this.word = word;
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public int compareTo(WordCounter o) {
        return Double.compare(o.counter, this.counter);
    }

    @Override
    public String toString() {
        return word + ";" + counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WordCounter WordCounter = (WordCounter) o;

        return Double.compare(WordCounter.counter, counter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(counter);
    }
}
