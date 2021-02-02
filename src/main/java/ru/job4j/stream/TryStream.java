package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TryStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 2, -4, 5, -9, 13);
        List<Integer> filteredList = list.stream()
                .filter(x -> x > 0)
                .collect(Collectors.toList());
        System.out.println(filteredList);
    }
}
