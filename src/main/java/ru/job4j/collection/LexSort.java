package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftWords = left.split(". ");
        String[] rightWords = right.split(". ");
        if (Integer.parseInt(leftWords[0]) > Integer.parseInt(rightWords[0])) {
            return 1;
        } else if (Integer.parseInt(leftWords[0]) < Integer.parseInt(rightWords[0])) {
            return -1;
        }
        return 0;
    }
}
