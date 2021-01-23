package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int index = left.length();
        if (left.length() > right.length()) {
            index = right.length();
        }
        for (int i = 0; i < index; i++) {
            if (Character.compare(left.charAt(i), right.charAt(i)) > 0 ) {
                return 1;
            } else if (Character.compare(left.charAt(i), right.charAt(i)) < 0 ) {
                return -1;
            }
        }
        if (Integer.compare(left.length(), right.length()) > 0) {
            return 1;
        } else if (Integer.compare(left.length(), right.length()) < 0) {
            return -1;
        }
        return 0;
    }
}
