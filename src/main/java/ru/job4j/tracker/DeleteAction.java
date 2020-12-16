package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete Item ====");
        String id = input.askStr("Введите id заявки для удаления");
        if (tracker.delete(Integer.valueOf(id))) {
            out.println("Заявка id: " + id + " успешно удалена");
        } else {
            out.println("Заявки id: " + id + " не удалена. Возникла ошибка");
        }
        return true;
    }
}
