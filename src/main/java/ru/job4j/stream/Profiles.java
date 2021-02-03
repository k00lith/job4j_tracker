package ru.job4j.stream;

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
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .collect(Collectors.toList());
    }
}
