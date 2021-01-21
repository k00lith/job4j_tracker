/**
 * по имени
 * по возрастанию
 */
package ru.job4j.collection;

import java.util.Comparator;

public class JobIncreaseByName implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
