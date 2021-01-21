package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
//        if (!users.containsKey(user)) {
//            users.put(user, new ArrayList<Account>());
//        }
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        List<Account> lst = users.get(findByPassport(passport));
//        boolean same = true;
//        for (Account acc : lst) {
//            if (acc.equals(account)) {
//                same = false;
//                break;
//            }
//        }
//        if (same) {
//            lst.add(account);
//        }
        if (!lst.contains(account)) {
            lst.add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User usr : users.keySet()) {
            if (passport.equals(usr.getPassport())) {
                return usr;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> lst = users.get(findByPassport(passport));
        if (lst != null) {
            for (Account acc : lst) {
                if (requisite.equals(acc.getRequisite())) {
                    return acc;
                }
            }
        }
        return null;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт.
     * Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят), то метод должен вернуть false.
    */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
            destAcc.setBalance(destAcc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}

