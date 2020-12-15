package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите id заявки для редактирования");
        String name = input.askStr("Введите имя заявки, на которую будет произведена замена ");
        Item itemNew = new Item();
        itemNew.setName(name);
        if (tracker.replace(Integer.valueOf(id), itemNew)) {
            System.out.println("Замена заявки id: " + id + " на новую заявку c именем: " + " успешно завершена");
        } else {
            System.out.println("Замена заявки id: " + id + " на новую заявку c именем: " + " не выполнена. Возникла ошибка");
        }
        return true;
    }
}
