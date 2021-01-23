package ru.job4j.tracker;

public enum Tracker1 {
    INSTANCE;
    private static final Tracker TRACKER = new Tracker();
    public static Tracker getTracker() {
        return TRACKER;
    }
}
