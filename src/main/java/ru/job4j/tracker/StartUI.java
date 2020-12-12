package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI extends Item{

    public static void main(String[] args) {
        Item item = new Item(1, "Тикет1");
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        //System.out.println(item.getDateCreated().format(formatter));
        Tracker tracker = new Tracker();
        tracker.add(item);
        //System.out.println("Название: " + tracker.findById(1).getName() + ", Номер: " + tracker.findById(1).getId());
        System.out.println(item);
    }

}
