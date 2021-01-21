package ru.job4j.tracker;

import junit.framework.TestCase;
import org.hamcrest.MatcherAssert;

import java.util.List;

import static org.hamcrest.Matchers.is;

public class ItemSortIncreaseTest extends TestCase {

    public void testCompare() {
        Tracker tracker1 = new Tracker();
        Tracker tracker2 = new Tracker();
        Item item1 = new Item("Alarm");
        Item item2 = new Item("Error");
        Item item3 = new Item("Xlite");
        tracker1.add(item3);
        tracker1.add(item1);
        tracker1.add(item2);
        List<Item> items1 = tracker1.findAll();
        tracker2.add(item1);
        tracker2.add(item2);
        tracker2.add(item3);
        List<Item> items2 = tracker2.findAll();
        items1.sort(new ItemSortIncrease());
        MatcherAssert.assertThat(items1, is(items2));

    }
}