package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI extends Item{

    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(item.getDateCreated().format(formatter));
    }

}
