package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find All";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== All Items ====");
        //Item[] items = tracker.findAll();
        List<Item> items = tracker.findAll();
        for (Item it : items) {
            System.out.println(it);
        }
        //for (int i = 0; i < items.length; i++) {
        //    out.println(items[i]);
        //}
        return true;
    }
}
