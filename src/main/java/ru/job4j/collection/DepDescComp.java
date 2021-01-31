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
        int rsl = rightWords[0].compareTo(leftWords[0]);
        if (rsl == 0) {
            return o1.compareTo(o2);
        } else {
            return rsl;
        }
    }
}
