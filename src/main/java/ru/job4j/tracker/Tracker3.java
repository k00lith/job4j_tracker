package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker3 {
    public static final Tracker INSTANCE = new Tracker();

    private Tracker3() { }

    public static Tracker getInstance() {
        return INSTANCE;
    }
}
