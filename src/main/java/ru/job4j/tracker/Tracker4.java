package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker4 {
    private Tracker4() {}

    public static Tracker4 getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Tracker4 INSTANCE = new Tracker4();
    }

    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] namesSame = new Item[size];
        int resize = 0;
        for (int index = 0; index < size; index++) {
            if (items[index].getName().equals(key)) {
                namesSame[index] = items[index];
                resize++;
            }
        }
        return Arrays.copyOf(namesSame, resize);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items[index] = item;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            System.arraycopy(items, (index + 1), items, index, (size - index));
            items[size - 1] = null;
            size--;
        }
        return rsl;
    }
}
