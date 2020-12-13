package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                for (int i = 0; i < items.length; i++) {
                    System.out.println(items[i]);
                }
            } else if (select == 2) {
                System.out.println("Введите id заявки для редактирования");
                String id = scanner.nextLine();
                System.out.println("Введите имя заявки, на которую будет произведена замена ");
                String name = scanner.nextLine();
                Item itemNew = new Item();
                itemNew.setName(name);
                if (tracker.replace(Integer.valueOf(id), itemNew)) {
                    System.out.println("Замена заявки id: " + id + " на новую заявку c именем: " + " успешно завершена");
                } else {
                    System.out.println("Замена заявки id: " + id + " на новую заявку c именем: " + " не выполнена. Возникла ошибка");
                }
            } else if (select == 3) {
                System.out.println("Введите id заявки для удаления");
                String id = scanner.nextLine();
                if (tracker.delete(Integer.valueOf(id))) {
                    System.out.println("Заявка id: " + id + " успешно удалена");
                } else {
                    System.out.println("Заявки id: " + id + " не удалена. Возникла ошибка");
                }
            } else if (select == 4) {
                System.out.println("Введите id заявки для поиска");
                String id = scanner.nextLine();
                Item itemFind = tracker.findById(Integer.valueOf(id));
                if (itemFind != null) {
                    System.out.println("Заявка " + itemFind.getName() + " ID " + itemFind.getId());
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
                System.out.println("Введите имя заявок для поиска");
                String name = scanner.nextLine();
                Item[] item = tracker.findByName(name);
                if (item.length > 0) {
                    for (int i = 0; i < item.length; i++) {
                        System.out.println(item[i]);
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }

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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
