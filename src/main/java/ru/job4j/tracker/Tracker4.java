package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker4 {
    private Tracker4() { }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        public static final Tracker INSTANCE = new Tracker();
    }
}
