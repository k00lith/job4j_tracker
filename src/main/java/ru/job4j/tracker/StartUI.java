package ru.job4j.tracker;


public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void findAll(Tracker tracker) {
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        String id = input.askStr("Введите id заявки для редактирования");
        String name = input.askStr("Введите имя заявки, на которую будет произведена замена ");
        Item itemNew = new Item();
        itemNew.setName(name);
        if (tracker.replace(Integer.valueOf(id), itemNew)) {
            System.out.println("Замена заявки id: " + id + " на новую заявку c именем: " + " успешно завершена");
        } else {
            System.out.println("Замена заявки id: " + id + " на новую заявку c именем: " + " не выполнена. Возникла ошибка");
        }

    }

    public static void  deleteItem(Input input, Tracker tracker) {
        String id = input.askStr("Введите id заявки для удаления");
        if (tracker.delete(Integer.valueOf(id))) {
            System.out.println("Заявка id: " + id + " успешно удалена");
        } else {
            System.out.println("Заявки id: " + id + " не удалена. Возникла ошибка");
        }

    }

    public static void  findItemId(Input input, Tracker tracker) {
        String id = input.askStr("Введите id заявки для поиска");
        Item itemFind = tracker.findById(Integer.valueOf(id));
        if (itemFind != null) {
            System.out.println("Заявка " + itemFind.getName() + " ID " + itemFind.getId());
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    public static void  findItemName(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя заявок для поиска");
        Item[] item = tracker.findByName(name);
        if (item.length > 0) {
            for (int i = 0; i < item.length; i++) {
                System.out.println(item[i]);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAll(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemId(input, tracker);
            } else if (select == 5) {
                StartUI.findItemName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
