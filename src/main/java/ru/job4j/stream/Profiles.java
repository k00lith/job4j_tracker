package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    /**
     * Возвращает список адресов клиентов
     *
     * @param profiles
     * @return
     */
    public static List<Address> collect(List<Profile> profiles) {
        // формируем список адресов через stream
        List<Address> addList = profiles.stream()
                .map(profile -> profile.getAddress())
                .collect(Collectors.toList());
        // сортируем по городу
        addList.sort((Address address1, Address address2)
                -> address1.getCity().compareTo(address2.getCity()));
        // возвращаем список адресов без дублей - с помощью distinct
        return addList.stream().distinct().collect(Collectors.toList());
    }
}
