package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();

        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if ("".equals(start)) {
                    start = el;
                    tmp.add(start);
                }
                if (!start.equals(el)) {
                    start = start + "/" + el;
                    tmp.add(start);
                }
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort();

    }

    public static void sortDesc(List<String> orgs) {
    }
}
