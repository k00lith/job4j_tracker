package ru.job4j.tracker;

import java.util.ArrayList;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find by Item's Name ====");
        String name = input.askStr("Введите имя заявок для поиска");
        ArrayList<Item> item = tracker.findByName(name);
        if (item.size() > 0) {
            for (Item value : item) {
                out.println(value);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
