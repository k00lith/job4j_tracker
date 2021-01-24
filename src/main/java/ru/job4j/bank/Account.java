package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс предназначен для хранения информации о балансе и реквизитах счета
 * клиента банка
 * @author k00lith
 * @version 1.0
 */
public class Account {
    /**
     * Поле для хранения реквизитов
     */
    private String requisite;
    /**
     * Поле для хранения баланса счета
     */
    private double balance;

    /**
     * У каждого клиентского счета в банке есть уникальный номер (реквизиты) и баланс
     * @param requisite реквизиты счета
     * @param balance баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод доступа к реквизитам аккаунта
     * @return возвращает реквизиты счета (аккаунта)
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод для изменения реквизитов аккаунта
     * @param requisite реквизиты
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод доступа к балансу аккаунта
     * @return возвращает баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод задает баланс аккаунта
     * @param balance баланс аккаунта
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
