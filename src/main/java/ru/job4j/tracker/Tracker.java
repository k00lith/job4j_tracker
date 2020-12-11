package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] namesWithoutNull = new Item[size];
        int resize = 0;
        for (int index = 0; index < size; index++) {
            Item id = items[index];
            if (id != null) {
                namesWithoutNull[index] = id;
                resize++;
            }
        }
        namesWithoutNull = Arrays.copyOf(namesWithoutNull, resize);
        return namesWithoutNull;
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
        namesSame = Arrays.copyOf(namesSame, resize);
        return namesSame;
    }
}