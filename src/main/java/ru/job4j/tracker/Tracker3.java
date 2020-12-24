package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker3 {
    private Tracker3() {}
    public static final Tracker INSTANCE = new Tracker();
    public static Tracker getInstance() {
        return INSTANCE;
    }
}
