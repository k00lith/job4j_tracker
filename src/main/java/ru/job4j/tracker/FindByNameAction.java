package ru.job4j.tracker;

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
        Item[] item = tracker.findByName(name);
        if (item.length > 0) {
            for (int i = 0; i < item.length; i++) {
                out.println(item[i]);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
