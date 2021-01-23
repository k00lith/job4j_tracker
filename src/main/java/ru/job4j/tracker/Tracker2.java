package ru.job4j.tracker;

public class Tracker2 {
    private static Tracker instance;

    private Tracker2() { }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
