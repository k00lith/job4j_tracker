package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] leftWords = o1.split("/");
        String[] rightWords = o2.split("/");
        List<String> leftWordsList = Arrays.asList(leftWords);
        List<String> rightWordsList = Arrays.asList(rightWords);
        ListIterator<String> listIterLeft = leftWordsList.listIterator();
        ListIterator<String> listIterRight = rightWordsList.listIterator();
        if (leftWords.length == rightWords.length) {
            if (leftWords.length == 1) {
                return rightWords[0].compareTo(leftWords[0]);
            }
        }
        if (leftWords.length == 1 || rightWords.length == 1) {
            if (rightWords[0].compareTo(leftWords[0]) == 0) {
                if (leftWords.length > rightWords.length) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        while (listIterLeft.hasNext() && listIterRight.hasNext()) {
            String left = listIterLeft.next();
            String right = listIterRight.next();
            if (left.compareTo(right) == 0) {
                continue;
            }
            return left.compareTo(right);
        }

        return -1;
    }
}
