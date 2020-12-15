package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find by Item's Id ====");
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
