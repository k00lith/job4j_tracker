package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit Item ====");
        String id = input.askStr("Введите id заявки для редактирования");
        String name = input.askStr("Введите имя заявки, на которую будет произведена замена ");
        Item itemNew = new Item();
        itemNew.setName(name);
        if (tracker.replace(Integer.valueOf(id), itemNew)) {
            out.println("Замена заявки id: " + id + " на новую заявку c именем: "
                    + " успешно завершена");
        } else {
            out.println("Замена заявки id: " + id + " на новую заявку c именем: "
                    + " не выполнена. Возникла ошибка");
        }
        return true;
    }
}
