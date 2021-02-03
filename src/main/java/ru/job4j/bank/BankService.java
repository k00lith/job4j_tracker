package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс эмулирует основные сервисы, которые может получить
 * клиент в банке
 * @author k00lith
 * @version 1.0
 */
public class BankService {
    /**
     * У каждого клиента может быть несколько счетов в банке. Для хранения
     * клиента и связанных с ним счетов используется коллекция типа Map
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод регистрации нового клиента в банке.
     * По умолчанию добавляем пустой список счетов - new ArrayList<Account>().
     * В методе есть проверка, что такого клиента еще нет в банке.
     * Если он есть, то нового клиента не добавляем.
     * @param user новый клиент
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод создания нового счета для определенного клиента.
     * Перед добавлением нового счета в List<Account> делаем
     * проверку, что такого счета у клиента нет.
     *
     * @param passport номер паспорта
     * @param account реквизиты
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> lst = users.get(user);
            if (!lst.contains(account)) {
                lst.add(account);
            }
        }
    }

    /**
     * Метод ищет клиента по номеру паспорта.
     * @param passport паспорт клиента
     * @return возвращает клиента, если клиента не найти
     * метод возвращает null
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет счет клиента по реквизитам
     * @param passport паспорт клиента
     * @param requisite реквизиты
     * @return возвращает счет, если не счет не найти
     * метод возвращает null
     */
    public Account findByRequisite(String passport, String requisite) {
        List<Account> lst = users.get(findByPassport(passport));
        if (lst != null) {
            return lst.stream()
                    .filter(u -> requisite.equals(u.getRequisite()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт.
     * Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят),
     * то метод должен вернуть false.
     * @param srcPassport паспорт клиента, с счета которого выполняется перевод
     * @param srcRequisite реквизиты счета, с которого выполняется перевод
     * @param destPassport паспорт клиента, на счет которого выполняется перевод
     * @param destRequisite реквизиты счета, на который выполняется перевод
     * @param amount сумма перевода
     * @return если перевод удался метод возвращает true, если нет - false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}

