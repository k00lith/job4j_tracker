package ru.job4j.tracker;

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
    public boolean execute(Input input,Tracker tracker) {
        out.println("=== All Items ====");
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            out.println(items[i]);
        }
        return true;
    }
}
