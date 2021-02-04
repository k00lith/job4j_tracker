package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
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
    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        rsl = Optional.of(users.keySet()
                .stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst()
                .orElse(null));
        return rsl;
    }

    /**
     * Метод ищет счет клиента по реквизитам
     * @param passport паспорт клиента
     * @param requisite реквизиты
     * @return возвращает счет, если не счет не найти
     * метод возвращает null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        List<Account> lst = users.get(findByPassport(passport));
        Optional<Account> rsl = Optional.empty();
        if (lst != null) {
             rsl = Optional.of(lst.stream()
                    .filter(u -> requisite.equals(u.getRequisite()))
                    .findFirst()
                    .orElse(null));
        }
        return rsl;
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
        Optional<Account> srcAcc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc.isPresent() && destAcc.isPresent() && srcAcc.get().getBalance() >= amount) {
            srcAcc.get().setBalance(srcAcc.get().getBalance() - amount);
            destAcc.get().setBalance(destAcc.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}

