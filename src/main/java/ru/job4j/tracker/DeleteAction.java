package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите id заявки для удаления");
        if (tracker.delete(Integer.valueOf(id))) {
            System.out.println("Заявка id: " + id + " успешно удалена");
        } else {
            System.out.println("Заявки id: " + id + " не удалена. Возникла ошибка");
        }
        return true;
    }
}
