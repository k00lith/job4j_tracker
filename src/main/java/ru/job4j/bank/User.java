package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс предназначен для хранения индивидуальной информации клиента банка
 * такую, как ФИО и номер паспорта
 * @author k00lith
 * @version 1.0
 */
public class User {
    /**
     * Поле хранит номер паспорта клиента
     */
    private String passport;
    /**
     * Поле хранит ФИО клиента
     */
    private String username;

    /**
     * У каждого клиента есть уникальный номер паспорта и ФИО.
     * ФИО может быть одинаковое
     * @param passport паспорт
     * @param username ФИО
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод для доступа к номеру паспорта клиента
     * @return номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод для изменения номера паспорта
     * @param passport новый номер паспорта клиента
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод для доступа к ФИО клиента
     * @return ФИО клиента
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод для изменения ФИО клиента
     * @param username новое ФИО клиента
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
