package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find by Item's Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите id заявки для поиска");
        Item itemFind = tracker.findById(Integer.valueOf(id));
        if (itemFind != null) {
            System.out.println("Заявка " + itemFind.getName() + " ID " + itemFind.getId());
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
