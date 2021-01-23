package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftWords = left.split(". ");
        String[] rightWords = right.split(". ");
        int leftNumber = Integer.parseInt(leftWords[0]);
        int rightNumber = Integer.parseInt(rightWords[0]);
        if (leftNumber > rightNumber) {
            return 1;
        } else if (leftNumber < rightNumber) {
            return -1;
        }
        return 0;
    }
}
